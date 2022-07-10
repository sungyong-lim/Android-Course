/** Lambda Expressions**/

/*
    - Syntax : { variable(s) -> body }
*/
package more
fun main() {
    var sum: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println(sum(10,5))

    var sum2 = {a: Int, b: Int -> println(a + b) }
    sum2(10, 5)

    var sum3: (Double, Int) -> Double = {a, b -> a + b}
    println(sum3(10.5, 5))

    var str: (String) -> Unit = {it -> println("$it !!")}
    str("String")

    var str2: (String) -> String = {it -> "$it !!"}
    println(str2("String"))

}