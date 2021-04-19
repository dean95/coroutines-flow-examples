import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Use the given [Interaction] interface and use its listener to transform the [Int] callback to a Flow that emits every
 * time the listener is called. When the Flow is being cancelled the listener should be set to null.
 *
 * Use case: Transform any listener into a Flow.
 */

private fun solve(interaction: Interaction): Flow<Int> = callbackFlow {
    interaction.listener = {
        when (it) {
            null -> close()
            else -> offer(it)
        }
    }
    awaitClose {
        interaction.listener = null
        cancel()
    }
}

private fun main() = runBlocking {
    val interaction = object : Interaction {
        override var listener: ((Int?) -> Unit)? = null
    }

    launch {
        solve(interaction)
            .collect {
                println(it)
            }
    }

    repeat(10) {
        interaction.listener?.invoke(it)
        delay(300)
    }

    interaction.listener?.invoke(null)

    Unit
}

private interface Interaction {
    var listener: ((Int?) -> Unit)?
}
