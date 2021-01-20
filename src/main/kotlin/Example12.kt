import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * In case the [source] Flow emits an error, don't emit the error and instead complete the Flow with a value of 5.
 *
 * Use case: Getting a network error and you want to recover and show some default state.
 */
private fun solve(source: Flow<Int>): Flow<Int> {
    TODO()
}

private fun main() = runBlocking {
    val source = flow {
        repeat(10) {
            delay(300)
            check(it < 6)
            emit(it)
        }
    }

    solve(source)
        .collect {
            println(it)
        }
}
