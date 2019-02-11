package com.cvdevelopers.baseapplication.baseclasses

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cvdevelopers.baseapplication.utils.ViewSubscriptionManager
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment: Fragment() {

    private val subscriptionManager = ViewSubscriptionManager()

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getResourceLayoutId(), container, false)
        return view
    }

    override fun onResume() {
        super.onResume()
        initializeSubscriptions(subscriptionManager)
        viewModel()?.onResume()
    }

    override fun onPause() {
        viewModel()?.onPause()
        super.onPause()
        subscriptionManager.dispose()
    }


    @LayoutRes
    abstract fun getResourceLayoutId(): Int

    abstract fun initializeSubscriptions(subscriptionManager: ViewSubscriptionManager)

    abstract fun viewModel(): BaseViewModel? // if the fragment does not have a view model, return null
}