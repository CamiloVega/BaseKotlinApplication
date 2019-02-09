package ${escapeKotlinIdentifiers(packageName)}

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.junit.Before

import org.junit.Test
import java.lang.RuntimeException

class ${className}ViewModelTest {

    @MockK
    lateinit var dataRepository: ${className}DataRepository

    private lateinit var SUT: ${className}ViewModel

    private var drDataStream = PublishSubject.create<Any>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = false)
        every { dataRepository.observeRepositoryData() } returns (drDataStream as Observable<Any>)
        SUT = ${className}ViewModel(dataRepository)
    }

    @Test
    fun initializeSubscriptions() {
        every { dataRepository.onResume() } just Runs
        SUT.onResume()
        verify { dataRepository.observeRepositoryData() }
    }

    @Test
    fun didYouReallyWriteTests(){
        //Did you really?
        throw RuntimeException()
    }
}
