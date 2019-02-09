package ${packageName};

import javax.inject.Inject
import kotlinx.android.synthetic.main.${escapeXmlAttribute(fragmentName)}.*

class ${className}Activity: BaseActivity() {

    @Inject
    lateinit var viewModel: ${className}ViewModel

    override fun getResourceLayoutId() = R.layout.${escapeXmlAttribute(fragmentName)}

    override fun initializeSubscriptions(subscriptionManager: ViewSubscriptionManager) {
        subscriptionManager.apply { 
            add(
                viewModel.observeDisplayData(),
                {
                    renderView(it)
                }, {
                    //Handle Error 
                }
            )
        }
    }

    override fun viewModel(): BaseViewModel? = viewModel

    private fun renderView(data: ${className}DisplayData) {
        //Display Data Here
        first_text.text = data.text
    }

    companion object {
        val LOG_TAG = ${className}Activity::class.java.simpleName.toString()
    }
}