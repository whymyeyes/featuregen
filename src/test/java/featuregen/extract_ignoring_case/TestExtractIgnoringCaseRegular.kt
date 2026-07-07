package featuregen.extract_ignoring_case

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Verifies removal of "hello" from "Hello World" ignoring case.
 */
class TestExtractIgnoringCaseRegular : BaseFeaturegenTest() {
    override val testDirShortName: String = "extract_ignoring_case/test_extract_ignoring_case_regular"
    override val args: List<String> = emptyList()

    @Test
    fun `should remove hello from Hello World ignoring case`() {
        performPositiveTest()
    }
}