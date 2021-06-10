import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

/**
 * Shift the work of [source] function to the given [dispatcher].
 *
 * Use case: You want to shift work to a particular [CoroutineDispatcher].
 */
private suspend fun solve(source: () -> Unit, dispatcher: CoroutineDispatcher) {
    source()
}

private fun main() = runBlocking {
    solve(::operation, Dispatchers.Default)
}

private fun operation() {
    println("I'm working in thread ${Thread.currentThread().name}")
}
