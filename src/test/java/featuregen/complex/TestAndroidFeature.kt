package featuregen.complex

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestAndroidFeature : BaseFeaturegenTest() {
    override val testDirShortName: String = "complex/test_android_feature"
    override val args: List<String> = listOf(
        "package=foo.bar",
        "fullName=FeatureTest",
    )

    @Test
    fun `process android feature template`() {
        performPositiveTest()
    }
}