import kotlinx.coroutines.*

/**
 * Call the given [function] when the [source] errors.
 *
 * Use case: Add some logging.
 */
private suspend fun solve(source: suspend () -> Int, function: (Throwable) -> Unit): Int? {
    return try {
        source()
    } catch (exception: Throwable) {
        function(exception)
        null
    }
}

private fun main() {
    runBlocking {
        solve(::source, ::logError)
    }
}

private suspend fun source(): Int {
    println("Running...")
    delay(500)
    throw RuntimeException()
}

private fun logError(error: Throwable) = println("An error occurred: $error")
