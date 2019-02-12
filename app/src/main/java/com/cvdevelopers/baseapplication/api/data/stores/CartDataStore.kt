package com.cvdevelopers.baseapplication.api.data.stores

import com.cvdevelopers.baseapplication.api.models.AdjustmentSchema
import com.cvdevelopers.baseapplication.api.models.CartData
import com.cvdevelopers.baseapplication.api.models.ItemSchema
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartDataStore @Inject constructor() {

    private var currentData = CartData(emptyList(), emptyList())
    set(value) {
        field = value
        publishCartData.onNext(value)
    }

    private val publishCartData = BehaviorSubject.create<CartData>()

    fun observeCartData() = publishCartData as Observable<CartData>

    fun addItemToCart(lineItem: ItemSchema) {
        val itemsList = ArrayList(currentData.itemList)
        itemsList.add(lineItem)
        val adjustments = generateAdjutmentsBasedOnLineItems(itemsList)
        currentData = CartData(itemsList, adjustments)
    }

    fun generateAdjutmentsBasedOnLineItems(lineItems: List<ItemSchema>): List<AdjustmentSchema> {
        val adjustmentList = ArrayList(currentData.adjutmentList)
        adjustmentList.add(AdjustmentSchema("Tax ${adjustmentList.size}", BigDecimal.valueOf(2.33)))
        return adjustmentList
    }

}