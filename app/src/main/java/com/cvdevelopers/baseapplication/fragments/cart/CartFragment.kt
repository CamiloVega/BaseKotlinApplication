package com.cvdevelopers.baseapplication.fragments.cart;

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.baseclasses.BaseFragment
import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.fragments.cart.model.CartDisplayData
import com.cvdevelopers.baseapplication.utils.ViewSubscriptionManager
import com.cvdevelopers.checklist.utils.poweradapter.adapter.RecyclerAdapter
import com.cvdevelopers.checklist.utils.poweradapter.adapter.RecyclerDataSource
import javax.inject.Inject
import kotlinx.android.synthetic.main.cart_fragment.*

class CartFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: CartViewModel

    @Inject
    lateinit var lineItemDataSource: RecyclerDataSource

    @Inject
    lateinit var adjustmentDataSource: RecyclerDataSource

    override fun getResourceLayoutId() = R.layout.cart_fragment

    override fun initializeSubscriptions(subscriptionManager: ViewSubscriptionManager) {
        subscriptionManager.apply {
            add(
                viewModel.observeDisplayData(),
                {
                    renderView(it)
                }, {
                    //Handle Error 
                }
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapterLineItems = RecyclerAdapter(lineItemDataSource)
        items_recyclerview.layoutManager = LinearLayoutManager(this.activity)
        items_recyclerview.adapter = adapterLineItems

        val adapterAdjustment = RecyclerAdapter(adjustmentDataSource)
        adjustment_recyclerview.layoutManager = LinearLayoutManager(this.activity)
        adjustment_recyclerview.adapter = adapterAdjustment
    }
    override fun viewModel(): BaseViewModel? = viewModel

    private fun renderView(data: CartDisplayData) {
        //Display Data Here
        adjustmentDataSource.setData(data.adjustmentList)
        lineItemDataSource.setData(data.itemList)
        checkout.setOnClickListener {
            viewModel.onCheckoutPressed()
        }
    }

    companion object {
        val LOG_TAG = CartFragment::class.java.simpleName.toString()
    }

}