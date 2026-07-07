package featuregen.expect

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestInterpolationWithSuffix : BaseFeaturegenTest() {
    override val testDirShortName: String = "expect/test_interpolation_with_suffix"
    override val args: List<String> = listOf(
        "feature=value",
    )

    @Test
    fun `should fail when template contains a similar variable name with a suffix`() {
        performPositiveTest()
    }
}