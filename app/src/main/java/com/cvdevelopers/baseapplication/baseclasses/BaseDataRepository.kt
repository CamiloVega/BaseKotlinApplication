package com.cvdevelopers.baseapplication.baseclasses

import com.cvdevelopers.baseapplication.utils.SubscriptionManager

abstract class BaseDataRepository {

    protected val subscriptionManager = SubscriptionManager()

    fun onResume() {
        initializeSubscriptions(subscriptionManager)
    }

    fun onPause() {
        subscriptionManager.dispose()
    }

    protected abstract fun initializeSubscriptions(subscriptionManager: SubscriptionManager)

}
