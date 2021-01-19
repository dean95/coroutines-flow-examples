package operators

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter

/**
 * The [distinct] operator filters a Flow by only allowing items through that have not already been emitted.
 */
fun <T> Flow<T>.distinct(): Flow<T> {
    val appeared = mutableSetOf<T>()
    return filter { appeared.add(it) }
}