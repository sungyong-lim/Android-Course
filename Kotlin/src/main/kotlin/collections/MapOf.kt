package collections

/** Map **/
/*
    - 키와 값을 쌍 형태로 데이터를 저장하는 컬렉션 // mapOf(key to value, ....)
    - 키는 유니크하고 하나의 값만 저장 가능
    - 만약 mapOf 안에 중복된 키가 있다면 마지막에 정의한 값이 키의 value가 됨
      ex) mapOf(1 to "A", 1 to "B") output : 1=B
*/

fun main() {
    val dayOfTheWeek = mapOf(1 to "Jan", 2 to "Feb", 3 to "Mar")

    println(dayOfTheWeek[3]) // 특정 요소 접근 -> [3]는 인덱스가 아니라 키를 의미

    // For Loop를 통한 출력
    for(key in dayOfTheWeek.keys) {
        println("$key is to ${dayOfTheWeek[key]}")
    }

    // data class를 이용한 mapOf
    // 키가 String,  값이 객체
    var fruitMap = mapOf("favorite" to Fruits("Apple", 2.5), "Ok" to Fruits("Grape", 1.0))

    println(fruitMap)

    for(key in fruitMap.keys) {
        println("$key is to ${fruitMap[key]}")
    }

    // mapOf => MutableMap
    val newFruitMap = fruitMap.toMutableMap()

    newFruitMap["FavoriteTwo"] = Fruits("Pear", 7.1) // 추가
    newFruitMap["OkTwo"] = Fruits("Water melon", 12.8) // 추가
    println(newFruitMap.toSortedMap()) // 오름차순 정렬
}

data class Fruits(val name: String, val price: Double)