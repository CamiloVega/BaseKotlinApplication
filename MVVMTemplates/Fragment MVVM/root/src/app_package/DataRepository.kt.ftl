package ${packageName};

import javax.inject.Inject

class ${className}DataRepository @Inject constructor(): BaseDataRepository() {

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply { 
            
        }
    }

    companion object {
        val LOG_TAG = ${className}DataRepository::class.java.simpleName.toString()
    }
}