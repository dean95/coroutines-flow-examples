import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.runBlocking

/**
 * In case the [source] is empty return a default value of 5.
 *
 * Use case: Continue with data if the stream is empty.
 */
private fun solve(source: Flow<Int>): Flow<Int> {
    TODO()
}

private fun main() = runBlocking {
    val source = emptyFlow<Int>()

    solve(source)
        .collect {
            println(it)
        }
}
