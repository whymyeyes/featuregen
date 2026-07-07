package featuregen.expect

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectTwice : BaseFeaturegenTest() {
    override val testDirShortName: String = "expect/test_expect_twice"
    override val args: List<String> = listOf(
        "feature=value",
    )

    @Test
    fun `should successfully interpolate expected variable value into template when expected is declared twice`() {
        performPositiveTest()
    }
}