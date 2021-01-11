import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * Increment each emitted value of the given [source] by 1.
 *
 * Use case: You want to transform the data.
 */

private fun solve(source: Flow<Int>): Flow<Int> = source.map(Int::inc)

private fun main() = runBlocking {
    val source = flow {
        repeat(10) {
            emit(it)
            delay(300)
        }
    }

    solve(source)
        .collect {
            println(it)
        }
}