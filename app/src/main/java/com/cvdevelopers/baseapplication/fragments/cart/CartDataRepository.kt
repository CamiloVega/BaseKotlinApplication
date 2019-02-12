package com.cvdevelopers.baseapplication.fragments.cart;

import com.cvdevelopers.baseapplication.api.data.stores.CartDataStore
import com.cvdevelopers.baseapplication.api.models.CartData
import com.cvdevelopers.baseapplication.baseclasses.BaseDataRepository
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class CartDataRepository @Inject constructor(val cartDataStore: CartDataStore) : BaseDataRepository() {

    private val publishViewModelData = BehaviorSubject.create<CartData>()

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply {
            add(
                cartDataStore.observeCartData(),
                {
                    publishViewModelData.onNext(it)
                },
                {

                }
            )
        }
    }

    fun observeRepositoryData() = publishViewModelData as Observable<CartData>

    companion object {
        val LOG_TAG = CartDataRepository::class.java.simpleName.toString()
    }
}