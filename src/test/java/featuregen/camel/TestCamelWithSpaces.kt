package featuregen.camel

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestCamelWithSpaces : BaseFeaturegenTest() {
    override val testDirShortName: String = "camel/test_camel_with_spaces"
    override val args: List<String> = emptyList()

    @Test
    fun `should convert PascalCase to camelCase`() {
        performPositiveTest()
    }
}