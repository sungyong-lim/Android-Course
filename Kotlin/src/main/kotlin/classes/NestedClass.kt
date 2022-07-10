package classes

/** 중첩 클래스(Nested Class) **/

/*
    * Nested Class
        - 다른 클래스 안에 생성되어 자동으로 정적
        - 데이터 멤버와 멤버 함수는 클래스 객체를 생성하지 않고도 접근할 수 있음
          즉, 객체를 만들지 않고, 함수와 멤버를 사용할 수 있는 것
        - 외부 클래스의 데이터 멤버에 접근할 수 없음 -> 일방적인 관계
          즉, 외부 클래스만 중첩 클래스 멤버에 접근할 수 있고 반대로는 안됨
*/

class OuterClass {
    private var name = "Mr.X"

    // 중첩 클래스 선언
    class NestedClass {
        var description = "code inside nested class"
        private var id = 101

        fun foo() {
            // println("name is $name")//외부 클래스(OuterClass)의 멤버에는 접근할 수 없음
            println("Id is $id")
        }

    }
}


fun main() {

    println(OuterClass.NestedClass().description) // 외부 클래스에서는 중첩 클래스 접근 가능
    // println(OuterClass.NestedClass().id) // 중첩 클래스에 접근 가능하더라도 private 접근제한자를 가지고 있기 때문에 id에는 접근 불가

    var obj = OuterClass.NestedClass()// 외부 클래스에서는 중첩 클래스 접근 가능

    obj.foo() // 외부 클래스에서는 중첩 클래스의 메서드에 접근 가능

}