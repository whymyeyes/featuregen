package featuregen.complex

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestLoginModule : BaseFeaturegenTest() {
    override val testDirShortName: String = "complex/test_login_module"
    override val args: List<String> = listOf(
        "package=foo.bar",
        "fullName=FeatureLogin"
    )

    @Test
    fun `process login module template`() {
        performPositiveTest()
    }
}