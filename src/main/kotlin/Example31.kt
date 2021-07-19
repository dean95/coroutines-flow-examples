import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import operators.repeat

/**
 * Duplicate the entire [source] three times. After emitting all events three times it should complete.
 *
 * Use case: You want to re-run a certain Flow a number of times.
 */
private fun solve(source: Flow<Int>): Flow<Int> = source.repeat(3)

private fun main() = runBlocking {
    val source = (1..3).asFlow().onEach { delay(300) }
    solve(source)
        .collect {
            println(it)
        }
}
