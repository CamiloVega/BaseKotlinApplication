package ${packageName};

import javax.inject.Inject

class ${className}Fragment: BaseFragment() {

    @Inject
    lateinit var viewModel: ${className}ViewModel

    override fun getResourceLayoutId() = R.layout.${escapeXmlAttribute(fragmentName)}

    override fun initializeSubscriptions(subscriptionManager: ViewSubscriptionManager) {
        subscriptionManager.apply { 
            
        }
    }

    override fun viewModel(): BaseViewModel? = viewModel

    companion object {
        val LOG_TAG = ${className}Fragment::class.java.simpleName.toString()
    }

}