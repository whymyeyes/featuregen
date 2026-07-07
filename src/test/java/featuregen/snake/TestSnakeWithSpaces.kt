package featuregen.snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures spaces are replaced by underscores.
 */
class TestSnakeWithSpaces : BaseFeaturegenTest() {

    override val testDirShortName: String = "snake/test_snake_with_spaces"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should replace spaces with underscores and convert to lowercase`() {
        performPositiveTest()
    }
}