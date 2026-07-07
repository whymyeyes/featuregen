package featuregen.snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures multiple consecutive underscores are collapsed into one.
 */
class TestSnakeDoubleUnderscore : BaseFeaturegenTest() {

    override val testDirShortName: String = "snake/test_snake_double_underscore"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should collapse multiple consecutive underscores into a single underscore`() {
        performPositiveTest()
    }
}