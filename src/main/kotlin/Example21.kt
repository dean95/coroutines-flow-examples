import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 * Return the first emission of the [source] in a blocking fashion.
 *
 * Use case: Sometimes you can't do everything reactively and need to break out of it.
 */
private fun solve(source: Flow<Int>): Int {
    TODO()
}

private fun main() = runBlocking {
    val source = (1..10).asFlow().onEach { delay(500) }

    println(solve(source))
}
