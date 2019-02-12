package com.cvdevelopers.baseapplication.fragments.menu;

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cvdevelopers.baseapplication.R
import com.cvdevelopers.baseapplication.baseclasses.BaseFragment
import com.cvdevelopers.baseapplication.baseclasses.BaseViewModel
import com.cvdevelopers.baseapplication.fragments.menu.adapter.MenuCategoryAdapter
import com.cvdevelopers.baseapplication.fragments.menu.model.MenuDisplayData
import com.cvdevelopers.baseapplication.utils.ViewSubscriptionManager
import javax.inject.Inject
import kotlinx.android.synthetic.main.menu_fragment.*

class MenuFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: MenuViewModel

    lateinit var adapter: MenuCategoryAdapter

    override fun getResourceLayoutId() = R.layout.menu_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = MenuCategoryAdapter()
        category_recycler_view.layoutManager = LinearLayoutManager(this.activity)
        category_recycler_view.adapter = adapter
    }
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

    override fun viewModel(): BaseViewModel? = viewModel

    private fun renderView(data: MenuDisplayData) {
        adapter.categoryList = data.categories
    }

    companion object {
        val LOG_TAG = MenuFragment::class.java.simpleName.toString()
    }

}