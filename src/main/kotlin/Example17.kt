import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Return a Flow that emits the value from the given [function] when being subscribed to.
 *
 * Use case: Emit functions result for each new collector.
 */

private fun solve(function: () -> Long): Flow<Long> = flow { emit(function()) }

private fun main() = runBlocking {
    val flow = solve(::operation)

    flow.collect {
        println(it)
    }

    delay(500)

    flow.collect {
        println(it)
    }
}

private fun operation(): Long {
    return 1000L
}
