package com.cvdevelopers.baseapplication.template_generated_classes;

import io.mockk.MockKAnnotations
import org.junit.Before

class TemplateDataRepositoryTest {

    private lateinit var SUT: TemplateDataRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = false)
        SUT = TemplateDataRepository()
    }
}