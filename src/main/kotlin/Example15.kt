import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Concatenate the [first] Flow with the [second] Flow, one after the other, without interleaving them.
 *
 * Use case: You have two sources of your data (cache & network request). You want to collect
 * both of them and keep the emission order.
 */
private fun solve(first: Flow<Int>, second: Flow<Int>): Flow<Int> = first.onCompletion {
    if (it == null) emitAll(second)
}

private fun main() = runBlocking {
    solve(cache(), network())
        .collect {
            println(it)
        }
}

private fun network() = (1..10).asFlow().onEach { delay(300) }

private fun cache() = (30..50).asFlow().onEach { delay(100) }
