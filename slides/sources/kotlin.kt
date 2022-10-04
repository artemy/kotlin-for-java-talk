package sources

import java.util.logging.Logger

class Example

val logger = Logger.getAnonymousLogger()

class ExampleRepository {
    fun findById(id: Long): Example {
        return Example()
    }
}

val exampleRepository = ExampleRepository()

data class Author(
    val name: String
)

data class Book(
    val id: Long,
    val authors: List<Author>,
    var publisherId: Long = 0L
)

enum class Make {
    VOLKSWAGEN
}

data class Car(
    val make: Make
)

class BookGenerator {
    var id: Long = 0L
    var retailerId: Long = 0L
    var authors: List<Author> = listOf()

    fun generate(): Book = Book(this.id, this.authors)
}

// tag::mutability[]
var mutableBuffer = "Example Buffer" // mutable variable
val immutableBuffer = "Example Buffer" // immutable variable
val explicitType: String = "Foo Bar" // explicit type declaration
// end::mutability[]

// tag::overloading[]
data class Shape(val shape: Shape) {
    operator fun plus(s2: Shape): Shape { /*...*/ }
}
// end::overloading[]

val car = Car(Make.VOLKSWAGEN)
fun dummy() {
    // tag::infix[]
    infix fun Car.ofMake(make: Make): Boolean = make == this.make

    // usage
    if (car ofMake Make.VOLKSWAGEN)
        println("This is a Volkswagen")
    // same as
    if (car.ofMake(Make.VOLKSWAGEN))
        println("This is a Volkswagen")
    // end::infix[]
}

fun sequences() {
    // tag::sequences[]
    val filteredStrings = listOf("cola", "coffee", "champagne")
        .filter { it.startsWith("c") } // automatically collected to List<T>
    // end::sequences[]
    // tag::sequences-lazyness[]
    val filteredStrings2 = listOf("cola", "coffee", "champagne")
        .filter { it.startsWith("c") }
        .first() // will cycle through all items
    // end::sequences-lazyness[]
    // tag::sequences-lazyness-2[]
    val filteredStrings3 = listOf("cola", "coffee", "champagne").asSequence()
        .filter { it.startsWith("c") }
        .first() // will only take the first item
    // end::sequences-lazyness-2[]
}

fun extensions() {
    // tag::extensions-1[]
    fun Car.ofMake(make: Make) =
        this.make == make // receiver object is available by `this`
    // end::extensions-1[]

    // tag::extensions-2[]
    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }
    // end::extensions-2[]
}

// tag::extensions-3[]
val Book.firstAuthor: Author
    get() = authors.first()
// end::extensions-3[]

// tag::typealiases[]
typealias IntList = List<Int>
// shortening generic types
typealias StringTable<K> = MutableMap<K, MutableList<String>>
// aliases for function types
typealias Predicate<T> = (T) -> Boolean
// end::typealiases[]

// tag::typealiases-2[]
typealias Predicate2<T> = (T) -> Boolean

fun foo(p: Predicate2<Int>) = p(42)

fun main() {
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // prints "true"

    val p: Predicate2<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // prints "[1]"
}
// end::typealiases-2[]
