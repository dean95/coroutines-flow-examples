import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Return a Flow that mirrors either the [first] or [second] Flow depending on whoever emits or terminates first.
 *
 * Use case: You have multiple sources and want to get the data from either one and then be consistent and not switch between multiple sources.
 */

private fun solve(first: Flow<Int>, second: Flow<Int>): Flow<Int> = flow {
    combine(first, second) { a, b ->

    }
}

private fun main() = runBlocking {
    val source1 = (1..20).asFlow().onEach { delay(200) }
    val source2 = (21..40).asFlow().onEach { delay(300) }


}
