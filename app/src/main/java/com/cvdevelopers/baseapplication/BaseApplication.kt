package com.cvdevelopers.baseapplication

import android.app.Activity
import android.app.Application
import com.cvdevelopers.baseapplication.dependencyinjection.components.DaggerApplicationComponent
import com.cvdevelopers.baseapplication.dependencyinjection.modules.ApplicationModule
import com.facebook.stetho.Stetho
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
        initializeComponents()
    }

    open fun initializeComponents() {
        Timber.plant(Timber.DebugTree())
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun activityInjector() = this.dispatchingActivityInjector

}