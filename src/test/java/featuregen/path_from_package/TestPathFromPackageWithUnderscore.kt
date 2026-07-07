package featuregen.path_from_package

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Corner case: ensures that underscores and digits within package segments
 * are preserved and not altered.
 */
class TestPathFromPackageWithUnderscore : BaseFeaturegenTest() {

    override val testDirShortName: String = "path_from_package/test_path_with_underscore"
    override val args: List<String> = emptyList()

    @Test
    fun `should preserve underscores and digits while converting dots to slashes`() {
        performPositiveTest()
    }
}