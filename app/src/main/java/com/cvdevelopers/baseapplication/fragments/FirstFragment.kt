package com.cvdevelopers.baseapplication.fragments

import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.baseclasses.BaseFragment
import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.utils.ViewSubscriptionManager
import kotlinx.android.synthetic.main.first_fragment_layout.*
import javax.inject.Inject

class FirstFragment: BaseFragment() {

    @Inject
    lateinit var firstFragmentViewModel: FirstFragmentViewModel

    override fun getResourceLayoutId() = R.layout.first_fragment_layout

    override fun initializeSubscriptions(subscriptionManager: ViewSubscriptionManager) {
        subscriptionManager.add(
            firstFragmentViewModel.observeDisplayData(),
            { textView.text = it}
        )
    }

    override fun viewModel(): BaseViewModel? = firstFragmentViewModel

}