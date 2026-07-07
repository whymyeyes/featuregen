package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLetIgnoresSpaceRight : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_let_ignores_space_right"
    override val args: List<String> = emptyList()

    @Test
    fun `should ignore space on the right side of the variable inside the let expression`() {
        performPositiveTest()
    }
}