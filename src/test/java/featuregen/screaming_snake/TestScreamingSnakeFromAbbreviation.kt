package featuregen.screaming_snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestScreamingSnakeFromAbbreviation : BaseFeaturegenTest() {

    override val testDirShortName: String = "screaming_snake/test_screaming_snake_from_abbreviation"
    override val args: List<String> = emptyList()

    @Test
    fun `snake should convert pascal case with acronyms to screaming snake case`() {
        performPositiveTest()
    }
}