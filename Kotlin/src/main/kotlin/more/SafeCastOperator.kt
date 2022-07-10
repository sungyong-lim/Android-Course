package more

fun main() {
    /** Unsafe Cast Operator Test **/

    // "nullable"로 선언된 변수는 "non-null"로 캐스팅 될 수 없음
    val obj: Any? = null
    val str: String = obj as String
    println(str) // java.lang.NullPointerException: null cannot be cast to non-null type kotlin.String


    // Any 타입의 변수를 String 타입으로 캐스트할 때 발생
    val obj2: Any = 123
    val str2: String = obj2 as String
    println(str2) // java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String

    // ===================================================================================

    /** Safe Cast Operator **/

    val location: Any? = "Kotlin"
    val safeString: String? = location as? String
    val safeInt: Int? = location as? Int
    val safeDouble: Double? = location as? Double

    println("safeString : $safeString") //output : safeString : Kotlin
    println("safeInt : $safeInt") // output : safeInt : null
    println("safeDouble : $safeDouble") // output safeDouble : null
}