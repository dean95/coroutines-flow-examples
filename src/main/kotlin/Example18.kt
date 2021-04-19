import kotlinx.coroutines.*
import operators.awaitFirst

/**
 * Await for completion of the first of given deferred values, and resume with that value right away.
 *
 * Use case: You have multiple sources and want to get the result only from the faster one.
 */
private suspend fun <T> solve(vararg deferreds: Deferred<T>): T = awaitFirst(*deferreds)

private fun main() = runBlocking {
    val value = solve(
        async { firstSource() },
        async { secondSource() },
        async { thirdSource() }
    )
    println(value)
}

private suspend fun firstSource(): Int {
    delay(100)
    return 1
}

private suspend fun secondSource(): Int {
    delay(200)
    return 2
}

private suspend fun thirdSource(): Int {
    delay(300)
    return 3
}
