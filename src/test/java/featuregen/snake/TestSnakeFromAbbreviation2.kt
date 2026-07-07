package featuregen.snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestSnakeFromAbbreviation2 : BaseFeaturegenTest() {

    override val testDirShortName: String = "snake/test_snake_from_abbreviation_2"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should convert pascal case with acronyms to snake case 2`() {
        performPositiveTest()
    }
}