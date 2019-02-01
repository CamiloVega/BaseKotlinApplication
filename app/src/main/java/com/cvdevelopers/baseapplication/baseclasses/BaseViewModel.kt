package com.cvdevelopers.baseapplication.baseclasses

import com.cvdevelopers.baseapplication.utils.SubscriptionManager

abstract class BaseViewModel () {

    protected val subscriptionManager = SubscriptionManager()

    fun onResume() {
        initializeSubscriptions(subscriptionManager)
        baseDataRepository()?.onResume()
    }

    fun onPause() {
        subscriptionManager.dispose()
        baseDataRepository()?.onPause()
    }

    protected abstract fun initializeSubscriptions(subscriptionManager: SubscriptionManager)

    protected abstract fun baseDataRepository(): BaseDataRepository? // if the View model does not have a data repository, return null

}
