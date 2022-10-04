package sources.kotlin

import sources.*


fun scope_functions() {
// tag::let[]
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let { println(it) }

// without let
    val numbers2 = mutableListOf("one", "two", "three", "four", "five")
    val resultList2 = numbers2.map { it.length }.filter { it > 3 }
    println(resultList2)
// end::let[]

// tag::let-nullability[]
    val str: String? = "Hello"
    val uppercase = str?.let { it.toUpperCase() }
    // without let
    val str2: String? = "Hello"
    val uppercase2 = if (str2 != null) str2.toUpperCase() else null
// end::let-nullability[]


    fun getBookById(id: Long) = Book(id, emptyList())

// tag::with[]
    val book1 = getBookById(12345)
    with(book1) {
        println("Book: $this")
        println("Book id is $id") // equivalent to ${this.id}
        println("# of authors is ${authors.size}")
    }
// end::with[]

// tag::run[]
    val book2: Book = BookGenerator().run {
        id = 12345
        retailerId = 98765
        lines = emptyList()
        generate()
    }
// end::run[]
// tag::run-extension[]
    val sqlQuery = run {
        val table = "books"
        val whereClause = "publishedDate <= NOW()"
        val order = "id ASC"
        "SELECT * FROM $table WHERE $whereClause ORDER BY $order"
    }
// end::run-extension[]

// tag::apply[]
    val book = Book(id = 12345L, emptyList()).apply {
        this.publisherId = 98765L
    }
// end::apply[]

    // tag::also[]
    fun findById(id: Long): Example {
        return exampleRepository.findById(id)
            .also { logger.info("retrieved record with $id") }
    }
// end::also[]

// tag::take[]
    val cars = listOf(Car(make = Make.VOLKSWAGEN))

    val volkswagenCars: List<Car>? =
        cars.takeIf { it.any { sl -> sl.make.name == "VOLKSWAGEN" } }
// without takeIf
    val volkswagenCars2 =
        if (cars.any { sl -> sl.make.name == "VOLKSWAGEN" }) {
            cars
        } else {
            null
        }
// end::take[]
}
