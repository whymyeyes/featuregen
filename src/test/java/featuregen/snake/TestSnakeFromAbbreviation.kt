package featuregen.snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestSnakeFromAbbreviation : BaseFeaturegenTest() {

    override val testDirShortName: String = "snake/test_snake_from_abbreviation"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should convert pascal case with acronyms to snake case`() {
        performPositiveTest()
    }
}