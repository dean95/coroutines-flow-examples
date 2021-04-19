import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Merge the [first] and [second] Flow together.
 *
 * Use case: There's something you want to execute and in your UI you have multiple trigger points.
 */
private fun solve(first: Flow<Int>, second: Flow<Int>): Flow<Int> = merge(first, second)

private fun main() = runBlocking {
    val first = (1..10).asFlow().onEach { delay(100) }
    val second = (11..20).asFlow().onEach { delay(200) }

    solve(first, second)
        .collect {
            println(it)
        }
}
