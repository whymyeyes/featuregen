package featuregen.expect

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectNegative : BaseFeaturegenTest() {
    override val testDirShortName: String = "expect/test_expect_negative"
    override val args: List<String> = emptyList()

    @Test
    fun `should fail when expected variable is absent`() {
        performNegativeTest()
    }
}