package com.cvdevelopers.baseapplication.activities;

import android.widget.Toast
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.baseclasses.BaseActivity
import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.utils.ViewSubscriptionManager
import javax.inject.Inject

class EntryActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: EntryViewModel

    override fun getResourceLayoutId() = R.layout.activity_entry

    override fun initializeSubscriptions(subscriptionManager: ViewSubscriptionManager) {
        subscriptionManager.apply {
            add (
                viewModel.observeDisplayData(),
                {
                    Toast.makeText(this@EntryActivity, it.message, Toast.LENGTH_SHORT).show()
                },{

                }
            )

        }
    }

    override fun viewModel(): BaseViewModel? = viewModel

    companion object {
        val LOG_TAG = EntryActivity::class.java.simpleName.toString()
    }
}