package com.cvdevelopers.baseapplication

import android.app.Activity
import android.app.Application
import com.cvdevelopers.baseapplication.dependencyinjection.components.DaggerApplicationComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var  dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    val appComponent = DaggerApplicationComponent.builder()
        .build()

    init {
        appComponent.inject(application = this)
    }

    override fun activityInjector() = this.dispatchingActivityInjector

}