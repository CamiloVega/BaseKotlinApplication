package com.cvdevelopers.baseapplication.dependencyinjection.components

import com.cvdevelopers.baseapplication.BaseApplication
import com.cvdevelopers.baseapplication.dependencyinjection.modules.ApplicationModule
import com.cvdevelopers.baseapplication.dependencyinjection.modules.DataModule
import com.cvdevelopers.baseapplication.dependencyinjection.modules.ActivityBindingModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component ( modules = [
    ApplicationModule::class,
    DataModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class
])

interface ApplicationComponent {
    fun inject(application: BaseApplication)
}