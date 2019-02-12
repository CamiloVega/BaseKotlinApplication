package com.cvdevelopers.baseapplication.activities;

import com.cvdevelopers.baseapplication.activities.model.EntryActivityDisplayData
import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.fragments.menu.model.MenuDisplayData
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import com.cvdevelopers.baseapplication.utils.ViewModelEventBus
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class EntryViewModel @Inject constructor(
    private val dataRepository: EntryDataRepository,
    private val eventBus: ViewModelEventBus
) : BaseViewModel() {

    override fun baseDataRepository() = dataRepository

    private val publishViewData = BehaviorSubject.create<EntryActivityDisplayData>()

    fun observeDisplayData() = publishViewData as Observable<EntryActivityDisplayData>

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply {
            add(
                eventBus.observeViewModelBus(),
                {
                    when (it){
                        is ViewModelEventBus.ViewModelEvent.DisplayFragment ->
                            publishViewData.onNext(EntryActivityDisplayData(it.message))
                    }
                }
            )
        }
    }

    companion object {
        val LOG_TAG = EntryViewModel::class.java.simpleName.toString()
    }
}