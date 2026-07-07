package featuregen.snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Verifies that the template engine correctly handles string transformations
 * and file output formatting.
 */
class TestSnakeFromPascalCase : BaseFeaturegenTest() {

    override val testDirShortName: String = "snake/test_snake_from_pascal_case"
    override val args: List<String> = emptyList()

    @Test
    fun `should convert PascalCase to snake_case without trailing newline`() {
        // This test ensures that:
        // 1. The 'snake()' function correctly inserts underscores.
        // 2. The template engine doesn't append an extra '\n' at the end of the file.
        performPositiveTest()
    }
}