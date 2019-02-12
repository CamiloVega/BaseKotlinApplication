package com.cvdevelopers.baseapplication.utils

import com.cvdevelopers.baseapplication.dependencyinjection.scope.ActivityScope
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

@ActivityScope
class ViewModelEventBus @Inject constructor() {

    private val publishEventBus = BehaviorSubject.create<ViewModelEvent>()

    fun putEventOnBus(event: ViewModelEvent) = publishEventBus.onNext(event)

    fun observeViewModelBus() = publishEventBus as Observable<ViewModelEvent>

    sealed class ViewModelEvent {
        data class DisplayFragment(val message: String): ViewModelEvent()
    }
}