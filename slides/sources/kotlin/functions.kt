package sources.kotlin

fun main() {
    // tag::functions-1[]
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    // function with expression body
    fun multiply(a: Int, b: Int) = a * b

    // function that doesn't any meaningful values
    fun logWarn(message: String): Unit { /*...*/ }

    // Unit is optional
    fun logInfo(message: String) { /*...*/ }

    // end::functions-1[]

    // tag::functions-2[]
    // Nothing type is for functions that never return
    // e.g. endless loops or throwing exceptions
    fun throwError(message: String): Nothing {/*...*/}
    // end::functions-2[]

    // tag::functions-9[]
    fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }
    // usage
    val concatenate = listOf("FOO", "BAR")
        .fold("") { acc: String, input: String -> acc + input }
    println(concatenate) // prints "FOOBAR"
    // end::functions-9[]
}
