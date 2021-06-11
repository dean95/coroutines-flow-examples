import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Shift all upstream work of [source] to the given [dispatcher].
 *
 * Use case: You want to shift work to a particular [CoroutineDispatcher].
 */
private fun solve(source: Flow<Int>, dispatcher: CoroutineDispatcher): Flow<Int> {
    TODO()
}

private fun main() = runBlocking {
    val source = (1..10).asFlow().onEach { delay(100) }

    solve(source, newSingleThreadContext("Five"))
        .collect {
            println("I'm collecting in thread ${Thread.currentThread().name}")
            println(it)
        }
}
