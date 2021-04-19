package operators

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.selects.select

/**
 * The [distinct] operator filters a Flow by only allowing items through that have not already been emitted.
 */
fun <T> Flow<T>.distinct(): Flow<T> {
    val appeared = mutableSetOf<T>()
    return filter { appeared.add(it) }
}

/**
 * Collect a [Flow] until [signal] emits an item.
 */
fun <T> Flow<T>.takeUntilSignal(signal: Flow<Unit>): Flow<T> = flow {
    coroutineScope {
        launch {
            signal.take(1).collect()
            this@coroutineScope.cancel()
        }
        collect {
            emit(it)
        }
    }
}

/**
 * Returns a Flow that emits only the first item emitted by the source Flow during specified [timeWindowMillis] duration.
 */
fun <T> Flow<T>.throttleFirst(timeWindowMillis: Long): Flow<T> = flow {
    var lastEmittedTime = 0L
    collect {
        val itemReceivedTime = System.currentTimeMillis()
        val delta = itemReceivedTime - lastEmittedTime
        if (delta >= timeWindowMillis) {
            emit(it)
            lastEmittedTime = System.currentTimeMillis()
        }
    }
}

/**
 * Awaits for completion of the first of given deferred values and resumes normally with that value without waiting for
 * other deferred computations to complete.
 */
suspend fun <T> awaitFirst(
    vararg deferreds: Deferred<T>
): T = select {
    deferreds.forEach {
        it.onAwait { result ->
            deferreds.forEach { it.cancel(CancellationException()) }
            return@onAwait result
        }
    }
}
