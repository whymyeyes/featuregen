package featuregen.comments

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestCommentVariable : BaseFeaturegenTest() {
    override val testDirShortName: String = "comments/test_comment_variable"
    override val args: List<String> = emptyList()

    @Test
    fun `commented variable should not affect output`() {
        performPositiveTest()
    }
}