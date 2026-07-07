package featuregen.screaming_snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures strings already containing underscores are handled correctly.
 */
class TestScreamingSnakeAlreadyScreamingSnake : BaseFeaturegenTest() {

    override val testDirShortName: String = "screaming_snake/test_screaming_snake_already_screaming_snake"
    override val args: List<String> = emptyList()

    @Test
    fun `screaming snake should maintain underscores in already screaming snake case strings`() {
        performPositiveTest()
    }
}