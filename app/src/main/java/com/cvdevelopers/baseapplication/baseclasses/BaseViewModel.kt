package com.cvdevelopers.baseapplication.baseclasses

import com.cvdevelopers.baseapplication.utils.SubscriptionManager

abstract class BaseViewModel () {

    val subscriptionManager = SubscriptionManager()

    fun onResume() {
        initializeSubscriptions(subscriptionManager)
        baseDataRepository()?.onResume()
    }

    fun onPause() {
        subscriptionManager.dispose()
        baseDataRepository()?.onPause()
    }

    abstract fun initializeSubscriptions(subscriptionManager: SubscriptionManager)

    abstract fun baseDataRepository(): BaseDataRepository? // if the View model does not have a data repository, return null

}
