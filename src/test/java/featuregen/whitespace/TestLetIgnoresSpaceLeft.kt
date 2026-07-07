package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLetIgnoresSpaceLeft : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_let_ignores_space_left"
    override val args: List<String> = emptyList()

    @Test
    fun `should ignore space on the left side of the variable inside the let expression`() {
        performPositiveTest()
    }
}