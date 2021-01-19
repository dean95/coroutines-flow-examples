import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Delay the entire [source] by 200ms. This includes subscribing, emissions and terminal events.
 *
 * Use case: Make a Flow "lazy" for some time. For instance, when wanting to postpone some UI action.
 */

private fun solve(source: Flow<Unit>): Flow<Unit> {
    TODO()
}

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
