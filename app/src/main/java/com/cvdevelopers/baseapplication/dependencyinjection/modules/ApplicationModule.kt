package com.cvdevelopers.baseapplication.dependencyinjection.modules

import android.app.Application
import com.cvdevelopers.baseapplication.BaseApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Module
    class ApplicationModule (private val application: BaseApplication) {

        @Provides
        fun providesApplication(): Application = application
    }
}