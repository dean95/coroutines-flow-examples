import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 * Delay each emission of the [source] by 300 milliseconds.
 *
 * Use case: Delay emission of events to simulate some indication.
 */
private fun solve(source: Flow<Int>): Flow<Int> = source.onEach { delay(300) }

private fun main() = runBlocking {
    val source = flowOf(1, 2, 3, 4, 5).onEach { delay(200) }

    val startTime = System.currentTimeMillis()
    solve(source)
        .collect {
            val endTime = System.currentTimeMillis()
            println("$it at ${endTime - startTime}")
        }
}
