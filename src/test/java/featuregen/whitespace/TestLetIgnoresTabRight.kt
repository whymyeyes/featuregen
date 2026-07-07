package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLetIgnoresTabRight : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_let_ignores_tab_right"
    override val args: List<String> = emptyList()

    @Test
    fun `should ignore tab on the right side of the variable inside the let expression`() {
        performPositiveTest()
    }
}