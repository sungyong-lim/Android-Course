package classes

/** 중첩 클래스(Nested Class)와 내부 클래스(Inner Class)**/

/*
    * Nested Class
        - 다른 클래스 안에 생성되어 자동으로 정적
        - 데이터 멤버와 멤버 함수는 클래스 객체를 생성하지 않고도 접근할 수 있음
          즉, 객체를 만들지 않고, 함수와 멤버를 사용할 수 있는 것
        - 외부 클래스의 데이터 멤버에 접근할 수 없음 -> 일방적인 관계
          즉, 외부 클래스만 중첩 클래스 멤버에 접근할 수 있고 반대로는 안됨

    * Inner Class
        - 키워드 "inner"로 다른 클래스 안에 만들어진 클래스
        - 즉, "inner"라고 표시된 중첩 클래스가 내부 클래스임
        - "private"이더라도 외부 클래스 멤버에 접근 가능
        - 내부 클래스는 외부 클래스 객체의 참조를 저장함

    * 중첩 클래스와 내부 클래스 차이점
        - 내부 클래스는 인터페이스 안에 또는 내부 중첩 클래스가 아닌 곳에 선언될 수 없음
*/

class OuterClass {
    private var name = "Mr.X"

    // 중첩 클래스 선언
    class NestedClass {
        var nestedDescription = "Code inside Nested Class"
        var nestedId = 101

        fun nestedFoo() {
            // println("name is $name")//외부 클래스(OuterClass)의 멤버에는 접근할 수 없음
            println("Id is $nestedId")
        }
    }

    // Inner Class 선언
    inner class InnerClass {
        var innerDescription = "Code inside Inner Class"
        private var innerId = 202

        fun innerFoo() {
            /* 내부 클래스이기 때문에 외부 클래스에 프로퍼티 접근 제한자가 "private"
               이어도 접근 가능 -> 이게 중첩 클래스와 차이점
            */
            println("name is $name")
            println("Id is $innerId")
        }
    }
}


fun main() {

    // Nested Class Test
    println("Nested Class Test")

    println(OuterClass.NestedClass().nestedDescription) // 외부 클래스에서는 중첩 클래스 접근 가능
    // println(OuterClass.NestedClass().nestedId) // 중첩 클래스에 접근 가능하더라도 private 접근제한자를 가지고 있기 때문에 id에는 접근 불가

    var obj = OuterClass.NestedClass()// 외부 클래스에서는 중첩 클래스 접근 가능

    obj.nestedFoo() // 외부 클래스에서는 중첩 클래스의 메서드에 접근 가능

    println("=====================================")

    // Inner Class Test
    println("Inner Class Test")
    println(OuterClass().InnerClass().innerDescription) // 외부 클래스에서는 내부 클래스 접근 가능
    // println(OuterClass.NestedClass().innerId) // 내부 클래스에 접근 가능하더라도 private 접근제한자를 가지고 있기 때문에 id에는 접근 불가
    var obj2 = OuterClass().InnerClass() //외부 클래스에서는 내부 클래스 접근 가능

    obj2.innerFoo()// 내부 클래스에서는 중첩 클래스의 메서드에 접근 가능

}