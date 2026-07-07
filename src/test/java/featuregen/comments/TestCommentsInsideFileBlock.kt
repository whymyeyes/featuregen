package featuregen.comments

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestCommentsInsideFileBlock : BaseFeaturegenTest() {
    override val testDirShortName: String = "comments/test_comments_inside_file_block"
    override val args: List<String> = emptyList()

    @Test
    fun `comments inside file blocks should remain untouched`() {
        performPositiveTest()
    }
}