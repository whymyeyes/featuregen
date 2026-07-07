package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectIgnoresTabRight : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_expect_ignores_tab_right"
    override val args: List<String> = listOf(
        "y=kx+b",
    )

    @Test
    fun `should ignore tab on the right side of the variable inside the expect expression`() {
        performPositiveTest()
    }
}