package com.cvdevelopers.baseapplication.fragments.cart

import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.junit.Before

import org.junit.Test
import java.lang.RuntimeException

class CartViewModelTest {

    @MockK
    lateinit var dataRepository: CartDataRepository

    private lateinit var SUT: CartViewModel

    private var drDataStream = PublishSubject.create<Any>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = false)
        every { dataRepository.observeRepositoryData() } returns (drDataStream as Observable<Any>)
        SUT = CartViewModel(dataRepository)
    }

    @Test
    fun initializeSubscriptions() {
        every { dataRepository.onResume() } just Runs
        SUT.onResume()
        verify { dataRepository.observeRepositoryData() }
    }

    @Test
    fun didYouReallyWriteTests() {
        //Did you really?
        throw RuntimeException()
    }
}
