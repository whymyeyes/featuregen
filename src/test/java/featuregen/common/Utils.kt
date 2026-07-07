package featuregen.common

import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal fun runFeaturegen(
    templateFile: String,
    workingDir: File,
    expectSuccess : Boolean,
    args: List<String>,
) {
    val scriptAbsolutePath = File(FEATUREGEN_PATH).absolutePath

    val cmd = mutableListOf(scriptAbsolutePath, templateFile) + args

    val process = ProcessBuilder(cmd)
        .directory(workingDir)
        .redirectErrorStream(true)
        .start()

    val output = process.inputStream.bufferedReader().readText()
    val exit = process.waitFor()

    println(output)

    assertEquals(
        expected = if (expectSuccess) 0 else 1,
        actual = exit,
        message = if (expectSuccess) "Featuregen engine failed" else "Featuregen engine retuned 0",
    )
}

internal fun assertDirectoriesMatch(expectedDir: File, actualDir: File) {
    assertTrue(expectedDir.exists(), "Expected directory does not exist: ${expectedDir.absolutePath}")
    assertTrue(actualDir.exists(), "Actual directory does not exist: ${actualDir.absolutePath}")

    val expectedFiles = expectedDir.walk()
        .filter { it.isFile }
        .filter { it.name != ".DS_Store" }
        .map { it.relativeTo(expectedDir).path }
        .toSet()

    val actualFiles = actualDir.walk()
        .filter { it.isFile }
        .map { it.relativeTo(actualDir).path }
        .toSet()

    assertEquals(expectedFiles, actualFiles, "Directory structure mismatch!")

    expectedFiles.forEach { relativePath ->
        val expectedFile = expectedDir.resolve(relativePath)
        val actualFile = actualDir.resolve(relativePath)

        val expectedContent = expectedFile.readText()
        val actualContent = actualFile.readText()

        assertEquals(
            expectedContent,
            actualContent,
            "Content mismatch in file: $relativePath"
        )
    }
}

private const val FEATUREGEN_PATH = "featuregen"