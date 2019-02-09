package ${packageName};

import javax.inject.Inject

class ${className}DataRepository @Inject constructor(): BaseDataRepository() {

    private val publishViewModelData = BehaviorSubject.create<Any>()

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply { 
            
        }
    }

    override fun onResume() {
        super.onResume()
        publishViewModelData.onNext("Hard coded text for ${className}")
    }

    fun observeRepositoryData() = publishViewModelData as Observable<Any>

    companion object {
        val LOG_TAG = ${className}DataRepository::class.java.simpleName.toString()
    }
}