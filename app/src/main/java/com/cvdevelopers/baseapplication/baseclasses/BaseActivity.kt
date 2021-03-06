package com.cvdevelopers.baseapplication.baseclasses

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.cvdevelopers.baseapplication.utils.ViewSubscriptionManager
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity(), HasSupportFragmentInjector {

    override fun supportFragmentInjector() = fragmentInjector

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    val subscriptionManager = ViewSubscriptionManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getResourceLayoutId())
    }

    override fun onResume() {
        super.onResume()
        viewModel()?.onResume()
    }

    override fun onPause() {
        viewModel()?.onPause()
        super.onPause()
    }

    @LayoutRes
    abstract fun getResourceLayoutId(): Int

    abstract fun initializeSubscriptions(subscriptionManager: ViewSubscriptionManager)

    abstract fun viewModel(): BaseViewModel? // if the activity does not have a view model, return null

}