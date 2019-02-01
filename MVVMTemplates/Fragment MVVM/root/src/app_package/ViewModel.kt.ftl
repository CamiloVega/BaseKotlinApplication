package ${packageName};

import javax.inject.Inject

class ${className}ViewModel @Inject constructor(
    private val dataRepository: ${className}DataRepository
): BaseViewModel() {

    override fun baseDataRepository() = dataRepository

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
         subscriptionManager.apply { 
            
        }
    }

    companion object {
        val LOG_TAG = ${className}ViewModel::class.java.simpleName.toString()
    }
}