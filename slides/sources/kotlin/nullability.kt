package sources.kotlin

import java.time.LocalDate

fun nullability() {
    // tag::nullability-1[]
    fun parseDate(input: String): LocalDate? { /*...*/ }

    val date: LocalDate? = parseDate("2022-01-02")
    // using returned nullable value
    print(date?.month) // safe call with ?.
    print(date!!.month) // unsafe call
    //end::nullability-1[]
    //tag::nullability-2[]
    // using if-else
    val month = if (date.month != null) date.month else LocalDate.now().month
    // simplified notation with elvis operator
    val month2 = date.month ?: LocalDate.now().month

    //end::nullability-2[]


    //tag::nullability-3[]
    val date2: LocalDate? = parseDate("2022-01-02")
    if (date2 != null) {
        print(date2) // smart cast to non-nullable
    } else {
        print("Unable to parse date")
    }
    //end::nullability-3[]

    // tag::nullability-4[]
    val date3: LocalDate? = parseDate("2022-01-02")
    // IllegalStateException is thrown if value would be null
    checkNotNull(date3) { "Date couldn't be parsed" }
    println("Parsed month: ${date3.month}") // smart cast into not-nullable
    // end::nullability-4[]
}
