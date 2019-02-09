package ${packageName};

import io.mockk.MockKAnnotations
import org.junit.Before

class ${className}DataRepositoryTest {

    private lateinit var SUT: ${className}DataRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = false)
        SUT = ${className}DataRepository()
    }
}