package featuregen.screaming_snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Verifies that the template engine correctly handles string transformations
 * and file output formatting.
 */
class TestScreamingSnakeFromPascalCase : BaseFeaturegenTest() {

    override val testDirShortName: String = "screaming_snake/test_screaming_snake_from_pascal_case"
    override val args: List<String> = emptyList()

    @Test
    fun `should convert PascalCase to screaming snake case without trailing newline`() {
        // This test ensures that:
        // 1. The 'screamingSnake()' function correctly inserts underscores.
        // 2. The template engine doesn't append an extra '\n' at the end of the file.
        performPositiveTest()
    }
}