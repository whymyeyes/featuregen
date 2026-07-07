package featuregen.snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures strings already containing underscores are handled correctly.
 */
class TestSnakeAlreadySnake : BaseFeaturegenTest() {

    override val testDirShortName: String = "snake/test_snake_already_snake"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should maintain underscores in already snake_case`() {
        performPositiveTest()
    }
}