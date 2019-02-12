package com.cvdevelopers.baseapplication.dependencyinjection.modules

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    internal fun providesGson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    @Provides
    @Singleton
    internal fun providesAssetManager(application: Application) = application.assets
}