package classes

// OOP(Object Oriented Programming)
// The 5 basic concepts
/*
    1. 변수와 타입
    2. 흐름제어
    3. 함수
    4. 컬렉션 -> 많은 요소를 한 군데에 저장하게 해주고 흐름제어의 도움을 받아 여러 요소를 반복
                 실행하게 해줌. 즉, 한 곳에 여러 값을 저장하고 싶은 경우 사용
    5. 상속을 포함한 클래스와 객체
* */
fun main() {

    var user = Person("Lim", "SY")
    var user2 = Person() // 초기값으로 정해준 Kim과 SY 출력
    var user3 = Person(lastName =  "Da") // firstName = Kim, lastname = Da
}


class Person(firstName: String = "Kim", lastName: String="SY") {
    // Initializer  -> 객체를 시작하기 위해 사용하는 것
    init {
        println("firstName : $firstName, lastName: $lastName")
    }

}