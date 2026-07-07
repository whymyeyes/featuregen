package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLetIgnoresLeadingEmptyLine : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_let_ignores_leading_empty_line"
    override val args: List<String> = emptyList()

    @Test
    fun `let should ignore leading empty line`() {
        performPositiveTest()
    }
}