package featuregen.expect

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectPositive : BaseFeaturegenTest() {
    override val testDirShortName: String = "expect/test_expect_positive"
    override val args: List<String> = listOf(
        "feature=value",
    )

    @Test
    fun `should succeed when expected variable is passed`() {
        performPositiveTest()
    }
}