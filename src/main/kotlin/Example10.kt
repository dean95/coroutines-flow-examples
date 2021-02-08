import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Use the [first] Flow and flatten it with the results of the [function] that returns a Flow.
 *
 * Use case: Get some user data and perform a network request with the user data and have both data accessible afterwards.
 */
private fun solve(first: Flow<Int>, function: (Int) -> Flow<String>): Flow<Pair<Int, String>> =
    first.flatMapLatest { firstValue ->
        function(firstValue).map { secondValue -> firstValue to secondValue }
    }

private fun main() = runBlocking {
    solve(getUserId(), ::getUsername)
        .collect {
            println(it)
        }
}

private fun getUserId() = flowOf(123)

private fun getUsername(id: Int) = flowOf("username")
