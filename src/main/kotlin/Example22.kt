import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import operators.chunked

/**
 * Group emissions of the [source] always in a list of 2 elements and skip every third element.
 *
 * Use case: Group related data while skipping over some of it.
 *
 * Input: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
 * Output: [0, 1], [3, 4], [6, 7], [9, 10]
 */
private fun solve(source: Flow<Int>): Flow<List<Int>> = source.chunked(chunkSize = 2, skip = 1)

private fun main() = runBlocking {
    val source = (0..10).asFlow().onEach { delay(300) }

    solve(source)
        .collect { println(it) }
}
