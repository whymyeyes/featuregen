package featuregen.extract_ignoring_case

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Verifies removal of suffix "_id" from "User_ID" ignoring case.
 */
class TestExtractIgnoringCaseWithUnderscore : BaseFeaturegenTest() {
    override val testDirShortName: String = "extract_ignoring_case/test_extract_ignoring_case_with_underscore"
    override val args: List<String> = emptyList()

    @Test
    fun `should remove underscore id from User_ID ignoring case`() {
        performPositiveTest()
    }
}