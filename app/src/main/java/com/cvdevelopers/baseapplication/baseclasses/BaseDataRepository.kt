package com.cvdevelopers.baseapplication.baseclasses

import com.cvdevelopers.baseapplication.utils.SubscriptionManager

abstract class BaseDataRepository {

    protected val subscriptionManager = SubscriptionManager()

    open fun onResume() {
        initializeSubscriptions(subscriptionManager)
    }

    open fun onPause() {
        subscriptionManager.dispose()
    }

    protected abstract fun initializeSubscriptions(subscriptionManager: SubscriptionManager)

}
