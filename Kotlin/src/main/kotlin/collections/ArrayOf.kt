package collections

/** 코틀린 켈렉션(Kotlin Collections) **/
/*
    * 컬렉션 분류
        - 특정 데이터 타입의 요소를 저정하는 클래스
        - 다른 타입의 요소를 저장하는 클래스
     - 즉, 코틀린에서 모든 데이터 타입은 그 요소를 저장한 클래스가 있음

     * Mutable Collection => 읽고, 변경 가능
        - arrayOf = 배열은 고정된 크기이므로 크기를 키우거나 새로운 인덱스를 추가할 수 없음

     * Immutable Collections => 읽기만 가능, 변경 X
        - listOf = arrayOf와 비슷하지만, 더 많은 연산 메서드 도우미가 있음, 필요 시 크기도 쉽게 키울 수 있음
        - setOf = 중복되는 값이 없게 하는 클래스
        - mapOf = 키와 값이 한 쌍으로 정리되는 데 키로 값을 찾을 수 있음
*/


fun main() {
    // IntArrayOf, DoubleArrayOf 등이 arrayOf 보다 안전함 -> why? 숫자, 소수 등 사용에 정확하기 때문

    // Int 타입 배열
    // val num: IntArray = intArrayOf(1,2,3,4,5)
    // 타입 추론이 가능 하기 때문에 IntArray 생략 가능
    // val num = intArrayOf(1,2,3,4)

    // Double 타입 배열
    // val numD: DoubleArray = doubleArrayOf(1.2, 324.1, 85.66)
    // 타입 추론이 가능 하기 때문에 DoubleArray 생략 가능
    // val numD = doubleArrayOf(1.2, 324.1, 85.66)

    val num = arrayOf(1,2,3,4,5,6)

    println(num) // 출력 : array의 주소로 저장된 위치 출력
    // 코틀린 유틸리티 메시지 사용해야 array 값 출력 가능 = value.contentToString()
    println(num.contentToString())

    for(elements in num) {
        println("${elements + 2}")
    }

    for(elements in num) {
        print(elements)
    }

    println("initial values ${num.contentToString()}") // 1,2,3,4,5,6
    num[0] = 6
    num[1] = 5
    num[4] = 2
    num[5] = 1

    val numD = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
    println("final values ${numD.contentToString()}") // 6,5,3,4,2,1    println("initial values ${num.contentToString()}") // 1,2,3,4,5,6
    numD[0] = 6.0
    numD[1] = 5.0
    numD[4] = 2.0
    numD[5] = 1.0
    println("final values ${numD.contentToString()}") // 6,5,3,4,2,1

    val days = arrayOf("Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat")
    println(days.contentToString())

    val fruits = arrayOf(Fruit("apple", 2.5), Fruit("grape", 12.4), Fruit("peach", 4.0))
    println(fruits.contentToString())

    for(i in fruits) {
        println("Name : ${i.name}, Price : ${i.price}")
    }

    // indices => 인덱스 값이 필요할 때 사용
    for(index in fruits.indices) {
        println("Name : ${fruits[index].name}, Price : ${fruits[index].price} is in index : $index")
    }

    val mix = arrayOf("a", 1, "b", "2", 2, 52.9, Fruit("apple", 45.2))
    println(mix.contentToString())



}

// 배열에 클래스를 넣기 위한 data class 생성
data class Fruit(val name: String, val price: Double)