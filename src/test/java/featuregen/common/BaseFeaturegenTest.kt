package featuregen.common

import org.junit.jupiter.api.BeforeEach
import java.io.File

abstract class BaseFeaturegenTest {

    abstract val testDirShortName: String
    abstract val args: List<String>

    private val testOutDir: String
        get() = "$TESTS_BUILD_RELATIVE_PATH/$testDirShortName"

    @BeforeEach
    fun setUp() {
        val testsDir = File(testOutDir)
        if (testsDir.exists()) {
            val deleted = testsDir.deleteRecursively()
            if (!deleted) {
                throw IllegalStateException("Cannot delete $testsDir")
            }
        }
    }

    private fun prepareFileStructure(): TestFileStructure {
        val testDir = File("src/test/resources/$testDirShortName")
        val input = testDir.resolve(TEMPLATE_FILE_SHORT_NAME).absolutePath
        val outDir = File(testOutDir).apply {
            mkdirs()
        }

        return TestFileStructure(
            testDir = testDir,
            input = input,
            outDir = outDir,
        )
    }

    protected fun performPositiveTest() {
        val fileStructure = prepareFileStructure()

        runFeaturegen(
            templateFile = fileStructure.input,
            workingDir = fileStructure.outDir,
            expectSuccess = true,
            args = args,
        )

        assertDirectoriesMatch(
            expectedDir = fileStructure.testDir.resolve(EXPECTED_DIR_SHORT_NAME),
            actualDir = fileStructure.outDir,
        )
    }

    protected fun performNegativeTest() {
        val fileStructure = prepareFileStructure()

        runFeaturegen(
            templateFile = fileStructure.input,
            workingDir = fileStructure.outDir,
            expectSuccess = false,
            args = args,
        )
    }
}

private data class TestFileStructure(
    val testDir: File,
    val input: String,
    val outDir: File,
)

private const val TEMPLATE_FILE_SHORT_NAME = "template.featuregen"
private const val EXPECTED_DIR_SHORT_NAME = "expected"
private const val TESTS_BUILD_RELATIVE_PATH = "build/tests"