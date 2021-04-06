import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

/**
 * When the [source] emits the same value as it did last time, don't allow it to travel downstream.
 *
 * Use case: You only want to observe changes of a value but don't care if the same value has been emitted consecutively.
 */
private fun solve(source: Flow<Int>): Flow<Int> = source.distinctUntilChanged()

private fun main() = runBlocking {
    val source = flowOf(1, 2, 3, 4, 4, 5, 6, 7, 7, 7, 8, 9)
    solve(source)
        .collect {
            println(it)
        }
}
