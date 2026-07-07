package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectIgnoresTabBoth : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_expect_ignores_tab_both"
    override val args: List<String> = listOf(
        "y=kx+b",
    )

    @Test
    fun `should ignore tabs on the both right and left sides of the variable inside the expect expression`() {
        performPositiveTest()
    }
}