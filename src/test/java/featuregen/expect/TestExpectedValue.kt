package featuregen.expect

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectedValue : BaseFeaturegenTest() {
    override val testDirShortName: String = "expect/test_expected_value"
    override val args: List<String> = listOf(
        "feature=value",
    )

    @Test
    fun `should successfully interpolate expected variable value into template`() {
        performPositiveTest()
    }
}