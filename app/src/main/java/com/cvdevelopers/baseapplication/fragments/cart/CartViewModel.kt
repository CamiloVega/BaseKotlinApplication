package com.cvdevelopers.baseapplication.fragments.cart;

import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.fragments.cart.model.CartAdjustmentDisplayData
import com.cvdevelopers.baseapplication.fragments.cart.model.CartDisplayData
import com.cvdevelopers.baseapplication.fragments.cart.model.CartItemDisplayData
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import com.cvdevelopers.baseapplication.utils.ViewModelEventBus
import com.cvdevelopers.baseapplication.utils.toCurrencyFormat
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val dataRepository: CartDataRepository,
    private val viewModelEventBus: ViewModelEventBus
) : BaseViewModel() {

    private val publishViewData = BehaviorSubject.create<CartDisplayData>()

    init {

    }

    fun observeDisplayData() = publishViewData as Observable<CartDisplayData>

    override fun baseDataRepository() = dataRepository

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        subscriptionManager.apply {
            add(
                dataRepository.observeRepositoryData(),
                {
                    val lineItems = it.itemList
                        .map {
                            CartItemDisplayData(it.id, "1", it.name, (it.price ?: "0").toCurrencyFormat())
                        }
                    val adjustments = it.adjutmentList
                        .mapIndexed { index, adjustmentSchema ->
                            CartAdjustmentDisplayData(index, adjustmentSchema.name, adjustmentSchema.value.toCurrencyFormat())
                        }
                    val data = CartDisplayData(lineItems, adjustments)
                    publishViewData.onNext(data)
                }, {
                    //Implement Error Handling
                }
            )
        }
    }

    fun onCheckoutPressed() {
        viewModelEventBus.putEventOnBus(ViewModelEventBus.ViewModelEvent.DisplayFragment("Check out Pressed"))
    }

    companion object {
        val LOG_TAG = CartViewModel::class.java.simpleName.toString()
    }
}


