package quiz

fun main() {
    // var list = ArrayList<Double>(5) // 동일한 정의
    var list: ArrayList<Double> = ArrayList(5)

    list.add(10.4)
    list.add(52.6)
    list.add(75.3)
    list.add(45.9)
    list.add(88.8)

    var result = 0.0

    for(i in list) {
        result += i
    }

    println("Average is ${result / list.size}")
}
