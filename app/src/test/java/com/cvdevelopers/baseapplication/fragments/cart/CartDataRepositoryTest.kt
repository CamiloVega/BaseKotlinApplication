package com.cvdevelopers.baseapplication.fragments.cart;

import io.mockk.MockKAnnotations
import org.junit.Before

class CartDataRepositoryTest {

    private lateinit var SUT: CartDataRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = false)
        SUT = CartDataRepository()
    }
}