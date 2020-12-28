import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/**
 * Don't emit odd numbers from the [source] Flow.
 *
 * Use case: You want to filter certain items out.
 */

private fun solve(source: Flow<Int>): Flow<Int> {
    TODO()
}

private fun main() = runBlocking {
    solve((1..10).asFlow())
            .collect {
                println(it)
            }
}