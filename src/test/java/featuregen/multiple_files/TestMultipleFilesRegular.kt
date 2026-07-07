package featuregen.multiple_files

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestMultipleFilesRegular : BaseFeaturegenTest() {
    override val testDirShortName: String = "multiple_files/test_multiple_files_regular"
    override val args: List<String> = emptyList()

    @Test
    fun `should create two files`() {
        performPositiveTest()
    }
}