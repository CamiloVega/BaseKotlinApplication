package com.cvdevelopers.baseapplication.dependencyinjection.modules

import com.cvdevelopers.baseapplication.MainActivity
import com.cvdevelopers.baseapplication.dependencyinjection.scope.FragmentScope
import com.cvdevelopers.baseapplication.fragments.FirstFragment


import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ViewBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun contributeFirstFragment(): FirstFragment
}