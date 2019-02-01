package com.cvdevelopers.baseapplication.utils

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ViewSubscriptionManager {
    private val disposables = CompositeDisposable()

    fun <T> add(source: Observable<T>, onNext: (T) -> Unit, onError: (Throwable) -> Unit = errorNotImplemented, onComplete: () -> Unit = {}): Disposable {
        return source.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(Consumer(onNext), Consumer(onError), Action(onComplete)).apply { disposables.add(this) }
    }

    fun <T> add(source: Single<T>, onNext: (T) -> Unit, onError: (Throwable) -> Unit = errorNotImplemented): Disposable {
        return source.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(Consumer(onNext), Consumer(onError)).apply { disposables.add(this) }
    }

    fun add(source: Completable, onComplete: () -> Unit = {}, onError: (Throwable) -> Unit = errorNotImplemented): Disposable {
        return source.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(onComplete, onError).apply { disposables.add(this) }
    }

    fun dispose() {
        disposables.clear()
    }

    companion object {
        private val errorNotImplemented: ((Throwable) -> Unit) = { throw NotImplementedError("Error case not implemented") }
        private const val THREAD_CHECK = "Must be on main thread"
    }
}