package more

/** 불안전 캐스트 연산자(Unsafe Cast Operator)와 안전한 캐스트 연산자(Safe Cast Operator) **/

/*
    * 불안전 캐스트 연산자
        - 어떤 때는 변수를 캐스트하지 못하고 예외 처리가 됨
        - 특정 타입의 것을 다른 타입으로 캐스트 하는 것
        - "as" 키워드 사용
        - "infix" 연산자 "as"에 의해 실행됨

    * 안전한 캐스트 연산자
        - "as?" 키워드 사용
        - 한 타입으로 안전하게 캐스트하도록 도와줌
        - 캐스팅할 수 없을 시 "ClassCastException" 처리 대신에 null 값을 부여함

*/

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