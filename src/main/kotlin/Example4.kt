import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Implement a toggle mechanism. Initially we want to return false.
 * Every time [source] emits, we want to negate the previous value.
 *
 * Use case: Some button that can toggle two states. For instance a switch between White & Dark theme.
 */

private fun solve(source: Flow<Unit>): Flow<Boolean> = source.scan(false) { oldValue, _ -> oldValue.not() }

private fun main() = runBlocking {
    val source = flow {
        repeat(10) {
            emit(Unit)
            delay(300)
        }
    }

    solve(source)
        .collect {
            println(it)
        }
}