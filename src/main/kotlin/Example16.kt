import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.runBlocking

/**
 * For each emission of the [source] Flow use the [function] and return its value.
 * Cancel all previously non terminated computations upon receiving
 * a new emission from [source].
 *
 * Use case: The [source] Flow is a search field and you want to issue a network request while disposing the
 * old requests in case the user has typed something new.
 */
fun solve(source: Flow<String>, function: suspend (String) -> Int): Flow<Int> = source.mapLatest {
    function(it)
}

private fun main() = runBlocking {
    val source = flow {
        emit("a")
        delay(100)
        emit("b")
    }

    solve(source, ::computation)
        .collect {
            println(it)
        }
}

private suspend fun computation(value: String): Int {
    println("Started computing $value")
    delay(200)
    println("Computed $value")
    return value.length
}
