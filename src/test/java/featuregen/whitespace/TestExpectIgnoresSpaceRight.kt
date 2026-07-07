package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectIgnoresSpaceRight : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_expect_ignores_space_right"
    override val args: List<String> = listOf(
        "y=kx+b",
    )

    @Test
    fun `should ignore space on the right side of the variable inside the expect expression`() {
        performPositiveTest()
    }
}