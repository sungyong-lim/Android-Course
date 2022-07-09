import kotlin.math.floor

/** 형 변환(Type casting)**/

fun main() {
    // String 형을 가진 list 생성
    val list1: List<String> = listOf("a", "B", "c")
    for(value in list1) {
        println(value)
    }

    // 모든 Type을 사용할 수 있는 list 생성
    val list2: List<Any> = listOf("Denis", 31, 5, "BDay", 70.9, "weights", "Kg")
    for(value in list2) {
        when(value) {
            is Int -> println("Integer: $value")
            // round = 반올림 // 70.4 -> 70.0 // 70.9 -> 80.0
            // ceil = 올림 // 70.4 -> 80.0 // 70.9 -> 80.0
            // floor = 내림  // 70.4 -> 70.0 // 70.9 -> 70.0
            is Double -> println("Double: $value, Floor: ${floor(value)}")
            is String -> println("String: $value, Length: ${value.length}")
            else -> println("Unknown Type")
        }
    }

    // Smart Cast
    val obj1: Any = "Software Developer"
    when(obj1) {
        !is String -> println("Not a String")
        else -> println("value: $obj1, Length: ${obj1.length}")
    }

    // Explicit (unsafe) Casting => as 키워드 사용
    val str1: String = obj1 as String
    // obj1을 String으로 사용해서 str1에 저장하고 길이를 반환
    println("str1: ${str1.length}")

    val obj2: Any = 1337
    // obj2가 string이 아니기 때문에 오류 발생
    //val str2: String = obj2 as String
    val str2: String? = obj2 as? String
    println(str2) // println null

    // Explicit (safe) Casting => as? 사용
    val obj3: Any = 13387
    val str3: String? = obj3 as? String
    println(str3) // println null

}