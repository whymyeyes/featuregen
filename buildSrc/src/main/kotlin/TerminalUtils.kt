import org.gradle.api.logging.Logger

fun String.red() = "\u001B[31m$this\u001B[0m"
fun String.green() = "\u001B[32m$this\u001B[0m"
fun String.yellow() = "\u001B[33m$this\u001B[0m"

fun Logger.quietTinted(s: String, tint: LogTint) {
    quiet(
        when (tint) {
            LogTint.GREEN -> s.green()
            LogTint.RED -> s.red()
            LogTint.YELLOW -> s.yellow()
        }
    )
}

enum class LogTint {
    GREEN,
    RED,
    YELLOW;
}