package featuregen.screaming_snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures multiple consecutive underscores are collapsed into one.
 */
class TestScreamingSnakeDoubleUnderscore : BaseFeaturegenTest() {

    override val testDirShortName: String = "screaming_snake/test_screaming_snake_double_underscore"
    override val args: List<String> = emptyList()

    @Test
    fun `screaming snake should collapse multiple consecutive underscores into a single underscore`() {
        performPositiveTest()
    }
}