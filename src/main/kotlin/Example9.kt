import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import operators.takeUntilSignal

/**
 * As long as the [trigger] Flow does not emit an item, keep the [main] Flow alive.
 *
 * Use case: Cancel a Flow when something has happened. For instance, stop polling when the user has been logged out.
 */

private fun solve(main: Flow<Unit>, trigger: Flow<Unit>): Flow<Unit> = main.takeUntilSignal(trigger)

private fun main() = runBlocking {

    val main = flow {
        while (true) {
            emit(Unit)
            delay(500)
        }
    }

    val trigger = flowOf(Unit)
        .onEach {
            delay(3000)
            println("Trigger emitted")
        }

    try {
        solve(main, trigger)
            .collect {
                println(it)
            }
    } catch (e: CancellationException) {
        println("Collection cancelled")
    }
}
