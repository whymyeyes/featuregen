package featuregen.camel

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestCamelFromSnakeCase : BaseFeaturegenTest() {
    override val testDirShortName: String = "camel/test_camel_from_snake_case"
    override val args: List<String> = emptyList()

    @Test
    fun `should convert PascalCase to camelCase`() {
        performPositiveTest()
    }
}