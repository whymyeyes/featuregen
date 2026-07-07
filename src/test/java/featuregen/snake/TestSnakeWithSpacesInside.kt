package featuregen.snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures spaces are replaced by underscores.
 */
class TestSnakeWithSpacesInside : BaseFeaturegenTest() {

    override val testDirShortName: String = "snake/test_snake_with_spaces_inside"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should replace spaces inside with underscores and convert to lowercase`() {
        performPositiveTest()
    }
}