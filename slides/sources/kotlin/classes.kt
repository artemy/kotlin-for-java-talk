package sources.kotlin

fun classes_1() {
    // tag::classes-1[]
    class Container {/*... */ }

    class Empty // empty class has no body
    // end::classes-1[]
}

// tag::classes-2[]
// class with implicit constructor
class Author(name: String) {/* ... */ }

// explicit constructor with visibility modifiers
class Publisher protected constructor(val books: MutableList<Book> = mutableListOf())

class Book(name: String) {
    constructor(name: String, publisher: Publisher) : this(name) {
        publisher.books.add(this)
    }
}
// end::classes-2[]

fun classes_3() {
    // tag::classes-3[]
    class Container(items: List<String>) {
        init {
            println("Class initialized with ${items.size} items")
        }
    }
    // end::classes-3[]
}

fun classes_4() {
    // tag::classes-4[]
    // yay no more Lombok!
    data class Person(
        val firstName: String,
        val lastName: String,
        val active: Boolean = true
    )
    val person = Person("Jon", "Snow")
    val person2 = Person(firstName = "Jon", lastName = "Snow", active = true)
    // end::classes-4[]
}


fun classes_5() {
    // tag::classes-5[]
    data class Container(val element: String)

    val container1 = Container(element = "foo")
    // copy of container 1
    val container2 = container1.copy()
    // altered copy of container 1
    val container3 = container1.copy(element = "bar")
    // end::classes-5[]
}

fun classes_7() {
    // tag::classes-7[]
    data class Result(val result: Int, val status: Status)

    fun function(...): Result {
        // computations

        return Result(result, status)
    }

    // Now, to use this function:
    val (result, status) = function(...)
    // end::classes-7[]
}
