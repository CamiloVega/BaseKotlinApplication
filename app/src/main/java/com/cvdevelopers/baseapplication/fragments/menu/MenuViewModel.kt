package com.cvdevelopers.baseapplication.fragments.menu;

import android.util.Log
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.api.models.MenuSchema
import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.fragments.menu.model.CategoryDisplayData
import com.cvdevelopers.baseapplication.fragments.menu.model.MenuDisplayData
import com.cvdevelopers.baseapplication.fragments.menu.model.MenuItemDisplayData
import com.cvdevelopers.baseapplication.utils.SubscriptionManager
import com.cvdevelopers.baseapplication.utils.toCurrencyFormat
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val dataRepository: MenuDataRepository
) : BaseViewModel() {

    private val publishViewData = BehaviorSubject.create<MenuDisplayData>()

    fun observeDisplayData() = publishViewData as Observable<MenuDisplayData>

    override fun baseDataRepository() = dataRepository

    override fun initializeSubscriptions(subscriptionManager: SubscriptionManager) {
        dataRepository.setLocationMenuId("1")
        subscriptionManager.apply {
            add(
                dataRepository.observeRepositoryData(),
                {data ->
                    when(data) {
                        is MenuSchema -> {
                            val categories = data.categories.mapIndexed { index, category ->
                                val colorIndex = index % data.categories.size
                                val displayItems = category.items.map { item ->
                                    MenuItemDisplayData(item.name, item.unitPrice.toCurrencyFormat(), COLOR_LIST[colorIndex],  this@MenuViewModel::onItemClicked)
                                }
                                CategoryDisplayData(category.name, displayItems)
                            }
                            publishViewData.onNext(MenuDisplayData(categories))
                        }
                    }
                }, {
                    //Implement Error Handling
                }
            )
        }
    }

    fun onItemClicked(selectedItem: MenuItemDisplayData) {
//        dataRepository.addItemToCart(itemId) TODO (This is where we decide what to send to the data repository so it sends it to the CartDataStore)
        Log.i(LOG_TAG, "Item ${selectedItem.name} was selected")
    }

    companion object {
        val LOG_TAG = MenuViewModel::class.java.simpleName.toString()
        //This is a dirty thing done on the Old app, used to be in the adapter, now is "business logic"
        val COLOR_LIST: List<Int> = arrayListOf(
            R.color.menu_navy,
            R.color.menu_dark_blue,
            R.color.menu_medium_blue,
            R.color.menu_teal,
            R.color.menu_light_green,
            R.color.menu_medium_green,
            R.color.menu_dark_green)
    }
}