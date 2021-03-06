import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Cast each emission of the [source] from [Any] to [String].
 *
 * Use case: You get some data from a bad source and you expect it to be of a certain type that you require.
 */
private fun solve(source: Flow<Any>): Flow<String> {
    TODO()
}

private fun main() = runBlocking {
    val source = flowOf<Any>("aa", "bb", "cc", "dd", "ee")
    solve(source)
        .collect {
            println(it)
        }
}
