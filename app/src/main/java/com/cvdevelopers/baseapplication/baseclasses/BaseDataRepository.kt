package com.cvdevelopers.baseapplication.baseclasses

import com.cvdevelopers.baseapplication.utils.SubscriptionManager

abstract class BaseDataRepository (){

    val subscriptionManager = SubscriptionManager()

    fun onResume() {
        initializeSubscriptions(subscriptionManager)
    }

    fun onPause() {
        subscriptionManager.dispose()
    }

    abstract fun initializeSubscriptions(subscriptionManager: SubscriptionManager)

}
