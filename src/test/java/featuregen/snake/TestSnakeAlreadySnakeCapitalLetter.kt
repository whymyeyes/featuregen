package featuregen.snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures strings already containing underscores are handled correctly.
 */
class TestSnakeAlreadySnakeCapitalLetter : BaseFeaturegenTest() {

    override val testDirShortName: String = "snake/test_snake_already_snake_capital_letter"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should maintain underscores in already snake_case strings but ensure lowercase`() {
        performPositiveTest()
    }
}