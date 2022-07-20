package collections

fun main() {

    val test = ArrayList<Int>()
    test.add(1)
    test.add(2)
    test.add(3)
    test.add(4)
    test.add(5)
    test.add(10)
    test.add(10)
    test.add(11)
    test.add(11)

    println(test)
    println(test.distinct()) // 중복 제거
    println(test.max()) // 가장 큰 값
    println(test.min()) // 가장 작은 값
    println(test.average()) // 평균

    // filter
    val filterTest = listOf("john", "jun", "minsu", "minjun")
    val filterTest2 = listOf(1,2,3,4,5,6,7,8,9,10)

    val result = filterTest.filter { it.startsWith("j") } //j 로 시작하는 문자
    val result2 = filterTest2.filter { it % 2 == 0 } // 짝수
    println("$result, $result2")

    // groupBy
    val groupTest = listOf("a","aa","aaa","aaaa")
    val result3 = groupTest.groupBy { it.length > 2 } // 길이가 2를 초과하는 문자열만 True 나머지 False
    println(result3)
    println(result3[false]) // 길이가 2를 초과하지 않은 문자열만 출력 즉, false 값만
    println(result3[true]) // 길이가 2를 초과하는 문자열만 출력 즉, True 값만
}