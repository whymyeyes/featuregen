package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLetIgnoresSpaceBoth : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_let_ignores_space_both"
    override val args: List<String> = emptyList()

    @Test
    fun `should ignore spaces on the both right and left sides of the variable inside the let expression`() {
        performPositiveTest()
    }
}