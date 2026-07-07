package featuregen.multiple_files

import featuregen.common.BaseFeaturegenTest
import org.junit.jupiter.api.Test

class TestMultipleFilesTheSameFile : BaseFeaturegenTest() {
    override val testDirShortName: String = "multiple_files/test_multiple_files_the_same_file"
    override val args: List<String> = emptyList()

    @Test
    fun `should write the content of the second block to the file when two file blocks have the same name`() {
        performPositiveTest()
    }
}