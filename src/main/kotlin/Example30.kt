import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Call the given [function] before [source] starts executing.
 *
 * Use case: Add some logging.
 */
private suspend fun solve(source: suspend () -> Unit, function: () -> Unit) {
    function()
    source()
}

private fun main() = runBlocking {
    solve(::source, ::log)
}

private suspend fun source() {
    delay(300)
    println("Done")
}

private fun log() = println("Logging...")
