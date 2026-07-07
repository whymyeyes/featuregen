package featuregen.camel

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestCamelAlreadyCamel : BaseFeaturegenTest() {

    override val testDirShortName: String = "camel/test_camel_already_camel"
    override val args: List<String> = emptyList()

    @Test
    fun `should return same string when string is already in camel case`() {
        performPositiveTest()
    }
}