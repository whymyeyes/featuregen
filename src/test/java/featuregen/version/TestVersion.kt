package featuregen.version

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestVersion : BaseFeaturegenTest() {

    override val testDirShortName: String = "version/test_version"
    override val args: List<String> = emptyList()

    @Test
    fun `should return version`() {
        performPositiveTest()
    }
}