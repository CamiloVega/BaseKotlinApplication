package com.cvdevelopers.baseapplication.dependencyinjection.modules

import com.cvdevelopers.baseapplication.dependencyinjection.scope.FragmentScope
import com.cvdevelopers.baseapplication.fragments.menu.MenuFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [MenuDataModule::class, RecyclerDataSourceModule::class])
    @FragmentScope
    abstract fun contributeMenuView(): MenuFragment

}