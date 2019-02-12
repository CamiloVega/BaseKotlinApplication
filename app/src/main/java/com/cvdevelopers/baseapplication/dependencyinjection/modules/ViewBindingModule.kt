package com.cvdevelopers.baseapplication.dependencyinjection.modules

import com.cvdevelopers.baseapplication.activities.EntryActivity
import com.cvdevelopers.baseapplication.dependencyinjection.scope.ActivityScope
import com.cvdevelopers.baseapplication.dependencyinjection.scope.FragmentScope
import com.cvdevelopers.baseapplication.fragments.FirstFragment
import com.cvdevelopers.baseapplication.fragments.menu.MenuFragment


import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ViewBindingModule {

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun contributeEntryActivity(): EntryActivity

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun contributeFirstFragment(): FirstFragment

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun contributeMenuView(): MenuFragment
}