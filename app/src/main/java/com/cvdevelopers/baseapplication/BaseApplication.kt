package com.cvdevelopers.baseapplication

import android.app.Activity
import android.app.Application
import com.cvdevelopers.baseapplication.dependencyinjection.components.DaggerApplicationComponent
import com.cvdevelopers.baseapplication.dependencyinjection.modules.ApplicationModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class BaseApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var  dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    val appComponent = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(application = this)
        Timber.plant(Timber.DebugTree())
    }

    override fun activityInjector() = this.dispatchingActivityInjector

}