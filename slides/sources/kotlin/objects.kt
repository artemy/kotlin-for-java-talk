package sources.kotlin

fun objects_1() {
    // tag::objects-1[]
    val helloWorld = object {
        val hello = "Hello"
        val world = "world"
        override fun toString() = "$hello $world!"
    }
    println(helloWorld)
    // end::objects-1[]
}

// tag::objects-2[]
object MyAwesomeObject {
    fun myAwesomeMethod() {}
    val container: Collection<String>
        get() = /* ... */
    fun staticMethod() {} // static method
}
// referring to the object methods
val temp = MyAwesomeObject.myAwesomeMethod(/* ... */)
// end::objects-2[]

// tag::objects-3[]
class User {
    companion object {
        private const val USER_TABLE = "users"
        fun create(): User { /* ... */ }
    }
}
// end::objects-3[]
