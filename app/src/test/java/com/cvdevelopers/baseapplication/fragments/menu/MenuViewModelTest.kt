package com.cvdevelopers.baseapplication.fragments.menu

import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.junit.Before

import org.junit.Test
import java.lang.RuntimeException

class MenuViewModelTest {

    @MockK
    lateinit var dataRepository: MenuDataRepository

    private lateinit var SUT: MenuViewModel

    private var drDataStream = PublishSubject.create<Any>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = false)
        every { dataRepository.observeRepositoryData() } returns (drDataStream as Observable<Any>)
        SUT = MenuViewModel(dataRepository)
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
