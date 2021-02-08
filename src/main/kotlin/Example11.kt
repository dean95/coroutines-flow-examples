import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import operators.throttleFirst

/**
 * Let the first emission of the [source] within a time window of 300ms travel downstream but don't emit
 * any other events until the next time window.
 *
 * Use case: Handle the click of a button right away but prevent double clicking by not handling multiple
 * click events within a given time window.
 */

private fun solve(source: Flow<Unit>): Flow<Unit> = source.throttleFirst(300)

private fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val source = flow {
        repeat(20) {
            emit(Unit)
            delay(100)
        }
    }

    solve(source).collect {
        println("Collecting: ${System.currentTimeMillis() - startTime}")
    }
}
