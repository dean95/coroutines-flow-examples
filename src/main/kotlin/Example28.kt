import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Call the given [function] when the [source] completes.
 *
 * Use case: Add some logging.
 */
private suspend fun solve(source: suspend () -> Unit, function: () -> Unit) {
    source()
    function()
}

private fun main() = runBlocking {
    solve(::operation, ::log)
}

private suspend fun operation() {
    println("Running...")
    delay(500)
}

private fun log() = println("Completed")
