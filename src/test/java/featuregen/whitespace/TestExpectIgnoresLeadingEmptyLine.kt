package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectIgnoresLeadingEmptyLine : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_expect_ignores_leading_empty_line"
    override val args: List<String> = listOf(
        "y=kx+b",
    )

    @Test
    fun `expect should ignore leading empty line`() {
        performPositiveTest()
    }
}