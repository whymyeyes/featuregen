package featuregen.functions

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestFailOnMissingFunction : BaseFeaturegenTest() {
    override val testDirShortName: String = "functions/test_fail_on_missing_function"
    override val args: List<String> = emptyList()

    @Test
    fun `should fail on missing function`() {
        performNegativeTest()
    }
}