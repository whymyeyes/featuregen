plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
}

kotlin {
    jvmToolchain(17)
}

dependencies {

    testImplementation(kotlin("test"))
}

tasks.named<Test>("test") {
    useJUnitPlatform()

    addTestListener(object : TestListener {

        override fun beforeSuite(suite: TestDescriptor) = Unit

        override fun afterSuite(suite: TestDescriptor, result: TestResult) {
            if (suite.parent == null) {
                printTestSummary(summary = result)
            }
        }

        override fun beforeTest(testDescriptor: TestDescriptor) = Unit

        override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) = Unit
    })
}

private fun printTestSummary(summary: TestResult) {
    fun log(s: String, tint: LogTint) = summaryLogger.quietTinted(s, tint)
    with(summary) {
        log(
            "Tests passed: ${successfulTestCount}/${testCount}",
            tint = if (successfulTestCount == testCount) LogTint.GREEN else LogTint.RED,
        )
        log(
            "Tests failed: ${failedTestCount}/${testCount}",
            tint = if (failedTestCount == 0L) LogTint.GREEN else LogTint.RED,
        )
        log(
            "Tests Skipped: ${skippedTestCount}/${testCount}",
            tint = if (skippedTestCount == 0L) LogTint.GREEN else LogTint.YELLOW,
        )
    }
}

private val summaryLogger = Logging.getLogger("test-summary")

