package com.cvdevelopers.baseapplication.activities;

import com.cvdevelopers.baseapplication.baseclasses.BaseDataRepository
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import javax.inject.Inject

class EntryDataRepository @Inject constructor() : BaseDataRepository() {

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply {

        }
    }

    companion object {
        val LOG_TAG = EntryDataRepository::class.java.simpleName.toString()
    }
}