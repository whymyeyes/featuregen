package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectIgnoresTabBefore : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_expect_ignores_tab_before"
    override val args: List<String> = listOf(
        "y=kx+b",
    )

    @Test
    fun `should ignore tab before the expect expression`() {
        performPositiveTest()
    }
}