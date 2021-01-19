import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import operators.distinct

/**
 * When the [source] emits the same value multiple times, only allow the first value to travel downstream.
 *
 * Use case: You never want to show the same value twice.
 */

private fun solve(source: Flow<Int>): Flow<Int> = source.distinct()

private fun main() = runBlocking {
    val source = flowOf(1, 2, 3, 3, 4, 5, 5, 6, 2, 7, 2, 1, 8)
    solve(source)
        .collect {
            println(it)
        }
}