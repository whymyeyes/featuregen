package featuregen.path_from_package

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

/**
 * Verifies conversion of dot-separated package strings to directory paths.
 */
class TestPathFromPackageRegular : BaseFeaturegenTest() {
    override val testDirShortName: String = "path_from_package/test_path_from_package_regular"
    override val args: List<String> = emptyList()

    @Test
    fun `should convert standard package dots to slashes`() {
        performPositiveTest()
    }
}