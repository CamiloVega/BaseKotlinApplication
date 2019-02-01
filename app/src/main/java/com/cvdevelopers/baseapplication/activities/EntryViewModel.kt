package com.cvdevelopers.baseapplication.activities;

import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import javax.inject.Inject

class EntryViewModel @Inject constructor(
    private val dataRepository: EntryDataRepository
) : BaseViewModel() {

    override fun baseDataRepository() = dataRepository

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply {

        }
    }

    companion object {
        val LOG_TAG = EntryViewModel::class.java.simpleName.toString()
    }
}