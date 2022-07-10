package classes

fun main() {

    var user = Persons("Lim", "sy", 26)

    user.stateHobby()

}

class Persons(firstName:String, lastName: String) {

    // 프로퍼티 = 멤버 변수 => 클래스 안의 변수
    var age: Int? = null
    var hobby = "watch Netflix"
    var firstName: String? = null


    init {
        println("Init = firstName: $firstName, lastName: $lastName, Age: $age")
    }

    // 보조 생성자 = 멤버 생성자
    constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName) {
        //this = 객체 생성 시 생성자에 전달된 age 값이 this 클래스의 age 값으로 지정되야함
        this.age = age
        this.firstName = firstName
        println("보조생성자 = firstName: $firstName, lastName: $lastName, Age: $age")
    }

    // 메서드 = 멤버 함수 => 클래스 안의 함수
    fun stateHobby() {
        println("$firstName\'s hobby is $hobby")
    }
}