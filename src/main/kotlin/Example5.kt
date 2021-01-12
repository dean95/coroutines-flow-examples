import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Sum up the latest values of [first] and [second] whenever one of the Flows emits a new value.
 *
 * Use case: Two input fields in a calculator that need to be summed up and the result should be updated
 * every time one of the inputs change.
 */

private fun solve(first: Flow<Int>, second: Flow<Int>): Flow<Int> = combine(first, second) { v1, v2 -> v1 + v2 }

private fun main() = runBlocking {
    val first = (1..10).asFlow().onEach { delay(200) }
    val second = (1..10).asFlow().onEach { delay(300) }

    solve(first, second)
        .collect {
            println(it)
        }
}
