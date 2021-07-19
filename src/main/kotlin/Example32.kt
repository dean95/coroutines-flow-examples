import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/**
 * Signal a [TimeoutCancellationException] when the given [source] does not terminate within 1 second.
 *
 * Use case: You want to terminate the operation if the timeout was exceeded.
 */
private suspend fun solve(source: suspend () -> Long): Long = withTimeout(1000) {
    source()
}

private fun main() = runBlocking {
    val result = solve(::source)
    println(result)
}

private suspend fun source(): Long {
    delay(500)
    return 1
}
