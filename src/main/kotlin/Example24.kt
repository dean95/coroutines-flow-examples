import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Upon completion of the [source] return the number of emissions from [source].
 *
 * Use case: Know how many emissions have been sent out.
 */
private suspend fun solve(source: Flow<Any>): Int = source.count()

private fun main() = runBlocking {
    val source = flowOf(1, 2, 3, 4, 5).onEach { delay(100) }
    println(solve(source))
}
