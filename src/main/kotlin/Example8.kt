import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Delay [source] by 200ms. This includes emissions and terminal events.
 *
 * Use case: Make a Flow "lazy" for some time. For instance, when wanting to postpone some UI action.
 */

private fun solve(source: Flow<Unit>): Flow<Unit> = source.onStart { delay(200) }

private fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val source = flow {
        repeat(10) {
            emit(Unit)
            delay(300)
        }
    }

    solve(source)
        .onStart { println("Collection started at: ${System.currentTimeMillis() - startTime}") }
        .collect {
            println("Item collected at: ${System.currentTimeMillis() - startTime}")
        }
}
