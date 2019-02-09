package ${packageName};

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class ${className}ViewModel @Inject constructor(
    private val dataRepository: ${className}DataRepository
): BaseViewModel() {

    private val publishViewData = BehaviorSubject.create<${className}DisplayData>()

    init {
        publishViewData.onNext(${className}DisplayData("${className}DisplayData Text"))
    }

    fun observeDisplayData() = publishViewData as Observable<${className}DisplayData>
    
    override fun baseDataRepository() = dataRepository

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
         subscriptionManager.apply { 
            
        }
    }

    companion object {
        val LOG_TAG = ${className}ViewModel::class.java.simpleName.toString()
    }
}