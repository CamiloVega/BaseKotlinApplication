package com.cvdevelopers.baseapplication.template_generated_classes;

import com.cvdevelopers.baseapplication.baseclasses.BaseDataRepository
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class TemplateDataRepository @Inject constructor() : BaseDataRepository() {

    private val publishViewModelData = BehaviorSubject.create<Any>()

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply {

        }
    }

    override fun onResume() {
        super.onResume()
        publishViewModelData.onNext("Hard coded text for Template")
    }

    fun observeRepositoryData() = publishViewModelData as Observable<Any>

    companion object {
        val LOG_TAG = TemplateDataRepository::class.java.simpleName.toString()
    }
}
