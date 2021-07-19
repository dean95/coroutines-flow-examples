import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 * Call the given [function] each time the [source] emits a value.
 *
 * Use case: Add some logging.
 */
private fun solve(source: Flow<Int>, function: (Int) -> Unit): Flow<Int> = source.onEach { function(it) }

private fun main() = runBlocking {
    val source = (1..10).asFlow().onEach { delay(300) }
    solve(source, ::log)
        .collect {
            println(it)
        }
}

private fun log(element: Int) = println("Emitted: $element")
