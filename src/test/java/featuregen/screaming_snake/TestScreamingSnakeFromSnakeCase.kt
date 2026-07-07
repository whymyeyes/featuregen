package featuregen.screaming_snake

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures strings already containing underscores are handled correctly.
 */
class TestScreamingSnakeFromSnakeCase : BaseFeaturegenTest() {

    override val testDirShortName: String = "screaming_snake/test_screaming_snake_from_snake_case"
    override val args: List<String> = emptyList()

    @Test
    fun `should convert snake_case string to screaming snake case`() {
        performPositiveTest()
    }
}