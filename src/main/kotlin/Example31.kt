import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/**
 * Duplicate the entire [source] three times. After emitting all events three times it should complete.
 *
 * Use case: You want to re-run a certain Observable a number of times.
 */
private fun solve(source: Flow<Int>): Flow<Int> {
    TODO()
}

private fun main() = runBlocking {
    val source = (1..5).asFlow()
    solve(source)
        .collect {
            println(it)
        }
}
