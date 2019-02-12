package com.cvdevelopers.baseapplication.fragments.menu;

import com.cvdevelopers.baseapplication.api.data.stores.MenuDataStore
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class MenuDataRepositoryTest {

    @MockK
    private  lateinit var menuDataStore: MenuDataStore

    private lateinit var SUT: MenuDataRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = false)
        SUT = MenuDataRepository(menuDataStore)
    }

    @Test
    fun setLocationId() {

    }
}