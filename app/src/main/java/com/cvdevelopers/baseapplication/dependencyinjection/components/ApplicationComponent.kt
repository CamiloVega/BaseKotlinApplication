package com.cvdevelopers.baseapplication.dependencyinjection.components

import com.cvdevelopers.baseapplication.BaseApplication
import com.cvdevelopers.baseapplication.dependencyinjection.modules.ApplicationModule
import com.cvdevelopers.baseapplication.dependencyinjection.modules.ViewBindingModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component ( modules = [
    ApplicationModule::class,
    ViewBindingModule::class,
    AndroidSupportInjectionModule::class
])

interface ApplicationComponent {
    fun inject(application: BaseApplication)
}