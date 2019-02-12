package com.cvdevelopers.baseapplication.dependencyinjection.modules

import com.cvdevelopers.baseapplication.fragments.menu.viewholder.MenuItemRenderer
import com.cvdevelopers.checklist.utils.poweradapter.item.ItemRenderer
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

import com.cvdevelopers.baseapplication.fragments.menu.viewholder.MenuItemRenderer.Companion.RENDER_KEY

@Module
abstract class MenuDataModule {

    @Binds
    @IntoMap
    @StringKey(RENDER_KEY)
    internal abstract fun bindRenderer(template: MenuItemRenderer): ItemRenderer<out RecyclerItem>

}
