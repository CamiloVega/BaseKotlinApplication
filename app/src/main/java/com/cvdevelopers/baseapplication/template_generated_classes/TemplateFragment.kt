package com.cvdevelopers.baseapplication.template_generated_classes;

import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.baseclasses.BaseFragment
import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.template_generated_classes.model.TemplateDisplayData
import com.cvdevelopers.baseapplication.utils.ViewSubscriptionManager
import javax.inject.Inject
import kotlinx.android.synthetic.main.template_fragment.*

class TemplateFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: TemplateViewModel

    override fun getResourceLayoutId() = R.layout.template_fragment

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

    private fun renderView(data: TemplateDisplayData) {
        //Display Data Here
        first_text.text = data.text
    }

    companion object {
        val LOG_TAG = TemplateFragment::class.java.simpleName.toString()
    }

}