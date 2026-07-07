package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLetIgnoresTabLeft : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_let_ignores_tab_left"
    override val args: List<String> = emptyList()

    @Test
    fun `should ignore tab on the left side of the variable inside the let expression`() {
        performPositiveTest()
    }
}