package basic
fun main() {

    // ?: Elvis Operator
    var nullableName: String? = null

    // 엘비스 연산자로 Default 값 부여
    // 만약 nullableName이 null 이라면 default 값인 Guest를 name에 할당하고 아니면 nullableName에 있는 값을 할당
    var name = nullableName ?: "Guest"
    println(name)

    //------------------------------------------------------------

    // !! non-null Assertion Operator -> nullable 타입을 non-null 타입으로 변경
    // 변수가 nullable이 아니라고 단정하는 것 -> 만약 변수가 nullable 이라면 NPE 발생
    println(nullableName!!.toLowerCase())
}