package collections

/** set **/
/*
    - 중복되는 데이터를 삭제하는 컬렉션
    - set 컬렉션은 무질서, 즉 요소가 분류되어 있지 않음
    - Immutable => setOf, Mutable => mutableSetOf, hashSetOf
*/


fun main() {

    val fruit = setOf("Orange", "Apple","Mango" ,"Grape", "Apple", "Orange")

    // Apple, Orange가 중복되므로 무시됨 => 그래서 size가 4
    println("$fruit, size: ${fruit.size}") // output : [Orange, Apple, Mango, Grape], size : 4
    // 알파벳 오름차순으로 정렬
    println(fruit.toSortedSet()) // output : [Apple, Grape, Mango, Orange]
    // 알파벳 내림차순으로 정렬
    println(fruit.toSortedSet(reverseOrder())) // output : [Orange, Mango, Grape, Apple]

    // setOf -> mutableList로 변경해서 할당
    val newFruit = fruit.toMutableList()
    // mutableList로 변경했기 때문에 추가 가능
    newFruit.add("Water melon")
    newFruit.add("Pear")
    // 기본형태가 set이기 때문에 중복은 무시됨
    println("$newFruit, size : ${newFruit.size}") // output : [Orange, Apple, Mango, Grape, Water melon, Pear],size : 6
    // 특정 요소에 접근할 때 사용하는 메서드
    println(newFruit.elementAt(4)) // output : Water melon


}
