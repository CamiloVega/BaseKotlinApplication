package com.cvdevelopers.baseapplication.template_generated_classes;

import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.template_generated_classes.model.TemplateDisplayData
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class TemplateViewModel @Inject constructor(
    private val dataRepository: TemplateDataRepository
) : BaseViewModel() {

    private val publishViewData = BehaviorSubject.create<TemplateDisplayData>()

    init {
        publishViewData.onNext(TemplateDisplayData("TemplateDisplayData Text"))
    }

    fun observeDisplayData() = publishViewData as Observable<TemplateDisplayData>

    override fun baseDataRepository() = dataRepository

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply {
            add(
                dataRepository.observeRepositoryData(),
                {
                    val data = TemplateDisplayData(it as String)
                    publishViewData.onNext(data)
                }, {
                    //Implement Error Handling
                }
            )
        }
    }

    companion object {
        val LOG_TAG = TemplateViewModel::class.java.simpleName.toString()
    }
}