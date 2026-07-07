package featuregen.screaming_snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestScreamingSnakeFromAbbreviation2 : BaseFeaturegenTest() {

    override val testDirShortName: String = "screaming_snake/test_screaming_snake_from_abbreviation_2"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should convert pascal case with acronyms to screaming snake case 2`() {
        performPositiveTest()
    }
}