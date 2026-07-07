package featuregen.complex

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class PhoneNumberValidatorJava : BaseFeaturegenTest() {
    override val testDirShortName: String = "complex/test_phone_number_validator_java"
    override val args: List<String> = listOf(
        "package=foo.bar",
        "fullName=PhoneNumber",
    )

    @Test
    fun `process java phone number validator template`() {
        performPositiveTest()
    }
}