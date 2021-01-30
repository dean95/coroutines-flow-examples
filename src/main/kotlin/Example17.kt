import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Return a Flow that emits the value from the given [function] when being subscribed to.
 *
 * Use case: Reactive types are lazy by default. Hence you might also want to get the value upon the subscription and not execution time.
 */

private fun solve(function: () -> Long): Flow<Long> {
    TODO()
}

private fun main() = runBlocking {
    val flow = solve(::getCurrentTime)

    flow.collect {
        println(it)
    }

    delay(500)

    flow.collect {
        println(it)
    }
}

private fun getCurrentTime(): Long {
    return System.currentTimeMillis()
}
