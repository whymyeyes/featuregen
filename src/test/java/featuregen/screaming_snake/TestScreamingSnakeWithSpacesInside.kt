package featuregen.screaming_snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures spaces are replaced by underscores.
 */
class TestScreamingSnakeWithSpacesInside : BaseFeaturegenTest() {

    override val testDirShortName: String = "screaming_snake/test_screaming_snake_with_spaces_inside"
    override val args: List<String> = emptyList()

    @Test
    fun `screaming snake should replace spaces inside with underscores and convert to lowercase`() {
        performPositiveTest()
    }
}