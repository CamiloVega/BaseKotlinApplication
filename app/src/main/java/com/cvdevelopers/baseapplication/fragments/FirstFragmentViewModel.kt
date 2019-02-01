package com.cvdevelopers.baseapplication.fragments

import android.util.Log
import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class FirstFragmentViewModel @Inject constructor(
    private val firstFragmentDataRepository: FirstFragmentDataRepository
): BaseViewModel() {

    private val dataTextModifier = BehaviorSubject.create<String>()

    override fun baseDataRepository() = firstFragmentDataRepository

    fun observeDisplayData() = dataTextModifier as Observable<String>

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.add(
            firstFragmentDataRepository.observeTextChanges(),
            {
                dataTextModifier.onNext("The time is: $it")
            }, {
                Log.e(LOG_TAG, "Changing text failed")
            }
        )
    }

    companion object {
        val LOG_TAG = FirstFragmentViewModel::class.java.simpleName
    }
}