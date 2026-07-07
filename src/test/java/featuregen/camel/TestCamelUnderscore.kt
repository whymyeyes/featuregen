package featuregen.camel

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestCamelUnderscore : BaseFeaturegenTest() {
    override val testDirShortName: String = "camel/test_camel_underscore"
    override val args: List<String> = emptyList()

    @Test
    fun `should convert acronym to lowercase`() {
        performPositiveTest()
    }
}