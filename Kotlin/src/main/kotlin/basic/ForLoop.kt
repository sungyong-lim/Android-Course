fun main() {
    for(i in 1..10) print(i)

    for(i in 1..10 step 2) print(i)

    println("------------")

    // until은 시작 ~ 끝-1
//    for(i in 1 until 10)
    for(i in 1.until(10))  print(i) // Same as

    println("------------")

//    for(i in 1 until 10 step 2) print(i)
    for(i in 1.until(10).step(2)) print(i) // Same as

    println("------------")

//    for(i in 10 downTo 1) print(i)
    for(i in 10.downTo(1)) println(i) // Same as

    println("------------")

//    for(i in 10 downTo  1 step 3) println(i)
    for(i in 10.downTo(1).step(3)) println(i) // Same as
}