package com.cvdevelopers.baseapplication.fragments

import com.cvdevelopers.baseapplication.baseclasses.BaseDataRepository
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class FirstFragmentDataRepository @Inject constructor(): BaseDataRepository() {

    private var textPublisher = BehaviorSubject.create<String>()

    fun observeTextChanges() = textPublisher as Observable <String>

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {

    }

    init {
        Observable
            .interval(1000L, TimeUnit.MILLISECONDS)
            .subscribe { textPublisher.onNext("$it") }
    }
}