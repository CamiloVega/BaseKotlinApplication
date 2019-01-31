package com.cvdevelopers.baseapplication.dependencyinjection.modules

import com.cvdevelopers.baseapplication.MainActivity


import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ViewBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeCustomerFacingActivity(): MainActivity

//    @ContributesAndroidInjector
//    @FragmentScope
//    abstract fun contributeCustomerFacingMainFragment(): VASIdentifyFragment
}