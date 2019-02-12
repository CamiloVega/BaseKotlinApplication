package com.cvdevelopers.baseapplication.fragments.menu;

import com.cvdevelopers.baseapplication.api.data.stores.CartDataStore
import com.cvdevelopers.baseapplication.api.data.stores.MenuDataStore
import com.cvdevelopers.baseapplication.api.models.ItemSchema
import com.cvdevelopers.baseapplication.baseclasses.BaseDataRepository
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MenuDataRepository @Inject constructor(val menuDataStore: MenuDataStore, val cartDataStore: CartDataStore) : BaseDataRepository() {

    private val publishViewModelData = BehaviorSubject.create<Any>()
    private var locationMenuId: String? = null

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        //NO OP
    }

    //There shouldn't be any subscriptions until the DR knows the locationID
    fun setLocationMenuId(locationMenuId: String) {
        this.locationMenuId = locationMenuId
        subscriptionManager.apply {
            add(
                menuDataStore.observeMenus(), {
                    locationMenuId.let { locationId ->
                        it[locationId]?.let { menu -> publishViewModelData.onNext(menu) }
                    }
                }
            )
        }
    }

    fun observeRepositoryData() = publishViewModelData as Observable<Any>

    fun addItemToCart(selectedItem: ItemSchema) {
        cartDataStore.addItemToCart(selectedItem)
    }

    companion object {
        val LOG_TAG = MenuDataRepository::class.java.simpleName.toString()
    }
}