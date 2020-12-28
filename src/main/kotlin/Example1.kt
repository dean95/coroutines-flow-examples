import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/**
 * Transform the given [value] into a Flow that emits the value and then completes.
 *
 * Use case: You want to transform some value to the reactive world.
 */

private fun solve(value: Int): Flow<Int> {
    TODO()
}

private fun main() = runBlocking {
    solve(5)
            .collect {
                println(it)
            }
}
