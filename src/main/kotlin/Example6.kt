import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Execute both [first] and [second] tasks in parallel and provide both results as a pair.
 *
 * Use case: Execute two network requests in parallel and wait for each other and process the combined data.
 */

private suspend fun solve(first: suspend () -> Int, second: suspend () -> Int): Pair<Int, Int> {
    TODO()
}

private fun main() = runBlocking {
    val timeMillis = measureTimeMillis {
        val result = solve(::first, ::second)
        println(result)
    }
    println("Time: $timeMillis")
}

private suspend fun first(): Int {
    delay(400)
    return 1
}

private suspend fun second(): Int {
    delay(500)
    return 2
}