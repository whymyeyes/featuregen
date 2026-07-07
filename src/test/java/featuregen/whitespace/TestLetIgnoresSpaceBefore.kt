package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLetIgnoresSpaceBefore : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_let_ignores_space_before"
    override val args: List<String> = emptyList()

    @Test
    fun `should ignore space before the let expression`() {
        performPositiveTest()
    }
}