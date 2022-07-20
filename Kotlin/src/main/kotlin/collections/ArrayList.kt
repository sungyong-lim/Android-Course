package collections

/** ArrayList **/
/*
    - 동적 배열을 생성하는 것 -> ArrayList 크기가 필요에 따라 증가 또는 감소할 수 있음
    즉, 특정 크기에 제한되지 않아서 좋음
    - 읽기, 쓰기 모두 가능
    - "ArrayList"는 삽입 순서를 따릅니다
    - 동기화되지 않아 중복 요소를 포함할 수 있음 -> 즉, 같은 값을 입력하는 것은 제한되지 않음

    * ArrayList 구조
        - ArrayList<E>() => 기본 생성자(비어 있는 배열 리스트를 만들 때 사용)
        - ArrayList(capacity: Int) => 용량을 정할 수 있는 생성자 즉, 요소의 최대량을 정할 수 있음
        - ArrayList(elements: Collection<E>) => 컬렉션을 기반으로 배열 리스트 생성, 즉 컬렉션 요소로
                                                채우고 필요할 때 사용할 수 있음

    * Functions of ArrayList
        - open fun add(elements: E): Boolean => add 함수는 특정 요소를 컬렉션에 추가할 수 있음
        - open fun clear() => clear 함수는 컬렉션에서 모든 요소를 제거
        - open fun get(index: Int): E => get 함수는 특정 인덱스 값의 정보를 돌려줌
        - open fun remove(element: E): Boolean => remove 함수는 컬렉션에서 특정 요소의 한 예시를 제거

*/

fun main() {

    // 기본 생성자
    val arrayList: ArrayList<Int> = ArrayList<Int>()
    arrayList.add(25)
    arrayList.add(15)

    // 인덱스 값 까지 출력
    for(i in arrayList.indices) {
        println("index : $i, value : ${arrayList[i]}")
    }

    // arrayList2에 5개에 값만 입력하게 제한
    val arrayList2: ArrayList<String> = ArrayList<String>(10)
    val list: MutableList<String> = mutableListOf<String>()

    list.add("One")
    list.add("Two")
    list.add("Three")

    arrayList2.addAll(list)

    // 인덱스 값 까지 출력
    for(i in arrayList2.indices) {
        println("index : $i, value: ${arrayList2[i]}")
    }

    // "iterator Collection"은 "itr"이 첫번째 element 를 가리키고 마지막 element 까지 이동할 수 있다
    val itr = arrayList2.iterator()

    // "itr"에 요소가 없을 때 까지 반복 즉, "arrayList2" 자체라고 생가하면 됨
    // "itr"에 다음 값이 있으면 println 으로 다음 값을 출력
    while(itr.hasNext()) {
        println(itr.next())
        // itr.previous() 는 다음 값이 없으면 뒤에 값으로 이동
    }

    // arrayList2 크기 출력
    println("size of arrayList2 : ${arrayList2.size}")

    /** get **/
    var getArrayList = ArrayList<String>()
    getArrayList.add("A")
    getArrayList.add("B")

    // 인덱스 값 까지 출력 
    for(i in getArrayList.indices) {
        println("index : $i, value : ${getArrayList[i]}")
    }

    // getArrayList[1]과 동일한 방법 => 인덱스에 접근
    println(getArrayList.get(1)) // output : B

}