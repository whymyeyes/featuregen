package featuregen.comments

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestFileBlockCommentInterpolation : BaseFeaturegenTest() {
    override val testDirShortName: String = "comments/test_file_block_comment_interpolation"
    override val args: List<String> = emptyList()

    @Test
    fun `variable interpolation within a commented line inside a file block should be performed`() {
        performPositiveTest()
    }
}