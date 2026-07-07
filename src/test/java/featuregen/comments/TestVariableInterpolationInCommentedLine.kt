package featuregen.comments

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestVariableInterpolationInCommentedLine : BaseFeaturegenTest() {
    override val testDirShortName: String = "comments/test_variable_interpolation_in_commented_line"
    override val args: List<String> = emptyList()

    @Test
    fun `should not interpolate variables in commented line`() {
        performPositiveTest()
    }
}