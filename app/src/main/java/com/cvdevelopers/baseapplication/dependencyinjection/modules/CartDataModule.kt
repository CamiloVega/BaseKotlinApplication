package com.cvdevelopers.baseapplication.dependencyinjection.modules

import com.cvdevelopers.baseapplication.fragments.cart.renderers.CartAdjutmentRenderer
import com.cvdevelopers.baseapplication.fragments.cart.renderers.CartItemRenderer
import com.cvdevelopers.baseapplication.fragments.menu.viewholder.MenuItemRenderer
import com.cvdevelopers.checklist.utils.poweradapter.item.ItemRenderer
import com.cvdevelopers.checklist.utils.poweradapter.item.RecyclerItem
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

import com.cvdevelopers.baseapplication.fragments.menu.viewholder.MenuItemRenderer.Companion.RENDER_KEY

@Module
abstract class CartDataModule {

    @Binds
    @IntoMap
    @StringKey(CartItemRenderer.RENDER_KEY)
    internal abstract fun bindItemRenderer(render: CartItemRenderer): ItemRenderer<out RecyclerItem>

    @Binds
    @IntoMap
    @StringKey(CartAdjutmentRenderer.RENDER_KEY)
    internal abstract fun bindAdjustmentRenderer(render: CartAdjutmentRenderer): ItemRenderer<out RecyclerItem>

}
