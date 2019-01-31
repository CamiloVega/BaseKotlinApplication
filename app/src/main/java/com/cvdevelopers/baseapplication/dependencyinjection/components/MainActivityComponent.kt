package com.cvdevelopers.baseapplication.dependencyinjection.components

import com.cvdevelopers.baseapplication.MainActivity
import com.cvdevelopers.baseapplication.dependencyinjection.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent
interface MainActivityComponent: AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MainActivity>() {}
}