package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLetIgnoresTabBefore : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_let_ignores_tab_before"
    override val args: List<String> = emptyList()

    @Test
    fun `should ignore tab before the let expression`() {
        performPositiveTest()
    }
}