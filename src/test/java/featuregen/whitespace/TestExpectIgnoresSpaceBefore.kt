package featuregen.whitespace

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestExpectIgnoresSpaceBefore : BaseFeaturegenTest() {

    override val testDirShortName: String = "whitespace/test_expect_ignores_space_before"
    override val args: List<String> = listOf(
        "y=kx+b",
    )

    @Test
    fun `should ignore space before the expect expression`() {
        performPositiveTest()
    }
}