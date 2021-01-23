import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Try the given [action] up to three times unless an [IllegalArgumentException] has been emitted.
 *
 * Use case: Retry an operation for a number of times or until a valid error occurred.
 */
private suspend fun solve(action: suspend () -> Unit) {
    TODO()
}

private fun main() = runBlocking {
    solve(::operation)
}

private suspend fun operation() {
    delay(300)
    println("Executing")
    throw RuntimeException()
}
