package com.cvdevelopers.baseapplication.baseclasses

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
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

    @LayoutRes
    abstract fun getResourceLayoutId(): Int

    abstract fun initializeSubscriptions(subscriptionManager: ViewSubscriptionManager)

    abstract fun viewModel(): BaseViewModel? // if the activity does not have a view model, return null

}