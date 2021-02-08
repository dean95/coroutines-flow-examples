# Coroutines/Flow Examples

## Use cases

* **Example 1** - Transform some value to the reactive world.
* **Example 2** - Transform the data.
* **Example 3** - Filter certain items out.
* **Example 4** - Implement a toggle mechanism with initial value.
* **Example 5** - Sum up the latest values of the two Flows whenever one of the Flows emits a new value.
* **Example 6** - Execute two operations in parallel, wait for each other and process the combined data.
* **Example 7** - When the source emits the same value multiple times, only allow the first value to travel downstream.
* **Example 8** - Delay the source by some fixed time.
* **Example 9** - Collect a Flow until another Flow emits an item.
* **Example 10** - Use one Flow and flatten it with the results of the function that returns a Flow.
* **Example 11** - Let the first emission of the source Flow within a specified time window travel downstream but don't
  emit any other events until the next time window.
* **Example 12** - In case the Flow emits an error, don't emit the error and instead complete the Flow with a default
  value.
