package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectIgnoresTabLeft : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_expect_ignores_tab_left"
    override val args: List<String> = listOf(
        "y=kx+b",
    )

    @Test
    fun `should ignore tab on the left side of the variable inside the expect expression`() {
        performPositiveTest()
    }
}