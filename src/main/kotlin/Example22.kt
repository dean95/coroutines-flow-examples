import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 * Group emissions of the [source] always in a list of 2 elements and skip every third element.
 *
 * Use case: Group related data while skipping over some of it.
 */
private fun solve(source: Flow<Int>): Flow<List<Int>> {
    TODO()
}

private fun main() = runBlocking {
    val source = (0..10).asFlow().onEach { delay(300) }

    solve(source)
        .collect { println(it) }
}
