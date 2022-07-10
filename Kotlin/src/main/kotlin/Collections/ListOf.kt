/** List **/
/*
    * List
        - 하나의 데이터 타입과 커스텀 객체 또는 클래스를 모두 저장할 수 있음
        - 새로운 값이 추가되면서 크기도 바뀔 수 있음
        - 아무 타입이나 사용 가능
        - 수정할 수 있는 Mutable 타입이 있고 수정할 수 없고 읽기만 가능한 Immutable 타입이 있음

    *  arrayOf, ListOf 차이점
        - arrayOf는 크기를 변경할 수 없다. 단, 내부 아이템들은 수정 가능함
        - listOf는 읽기 전용 -> 추가는 물론 내부 아이템도 수정 불가능  ex)  a[0] = 1 // a 배열에 0번째 인덱스를 1로 변경 불가능
*/

fun main() {

    val anyType = listOf("A", 1 , "b", true, false, "String", 2.54)
    println("value : $anyType, size : ${anyType.size}")

    val months = listOf("Jan", "Feb", "Mar")
    println(months[1]) // index로 접근 => "Feb" 출력

    // months.add("Apr") listOf 는 Immutable 이기 때문에 요소를 변경할 수는 있지만 추가를 할 수는 없음
    for(month in months) {
        println(months)
    }

    // Immutable 객체를 Mutable 객체로 변환해서 할당
    val addMonths = months.toMutableList()
    addMonths.add("Apr") // 기본적인 추가 방법

    val newMonths = arrayOf("May", "Jun")
    // 배열 아이템을 모두 추가
    addMonths.addAll(newMonths)
    println(addMonths)

    val newMonths2 = arrayOf("July", "Aug", "Sep", "Oct" ,"Nov", "Dec")
    addMonths.addAll(newMonths2)
    println(addMonths)

    // 특정 타입의 MutableList
    val days = mutableListOf<String>("Mon", "Tue", "Web", "Thu")
    days.add("Fri") // 추가
    days[1] = "Sun" // 수정
    days.removeAt(2)  // index 1번(Tue) 삭제  -> removeAll()
    println("initial list : $days")

    val removeList = arrayOf("Mon", "Thu")
    days.removeAll(removeList)
    println("update list : $days")

    days.removeAll(days) // days 전체 제거





}