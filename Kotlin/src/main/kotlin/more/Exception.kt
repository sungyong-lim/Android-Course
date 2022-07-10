package more

/** Exception Handling **/

/*
    - 프로그램의 런타임 문제를 처하는 것
    - ex) 저장 공간 부족, 범위를 벗어난 배열, 0으로 나눈 조건

    * Throwable Class
        - 예외를 실행할 수 있게 해줌
        - throw MyException(" ") // "throw"에 예외 이름을 사용하면 됨

    * 키워드
        - try => 예외를 발생시킬 수 있는 구문들을 포함
        - catch =>  try 블록에서 발생한 예외를 잡는 데 사용 -> 예외가 없으면 실행되지 않음
        - finally =>  예외가 처리되는지 여부에 관계없이 항상 실행 -> 그래서 중요한 코드 구문을 실행하는 데 사용
        - throw => 예외를 명시적으로 던지게 해줌 즉, 오류를 일으키기 위해 입력하는 것
                   오류가 어디서 나는지 테스트할 때 매우 유용함

    * Unchecked Exception
        - 코드 실수 때문에 던져지는 예외
        - Unchecked 예외는 앱이 실행되는 런타임에 확인됨
        - 실행 버튼을 눌러 앱을 컴파일할 때가 아닌 앱이 실행되는 런타임에서 확인됨

        * EX
            - arithmetic Exception => 숫자를 0으로 나눌 때 발생
            - ArrayIndexOutOfBoundException => 틀린 인덱스 값으로 배열을 확인할 때 발생
            - SecurityException => 보안 위반, 만약 "GPS"를 사용해야하는데 GPS 기능을 사용할 권한을 주지 않아 접근할 수 없을 때 발생
            - NullPointerException => null 객체에 메서드나 프로퍼티를 호출할 때 발생

    * Checked Exception
        - 컴파일 타임에 확인되는 예외

        * EX
            - IOException => 입출력 예외
            - SQLException etc  => SQL 예외

    * try catch
        - try { 예외를 던질 수 있는 코드 } catch(e : SomeException) { 예외를 처리하는 코드 }

    * Nested try-catch block
        - 코드 블록이 예외를 발생시키거나 블록 내의 다른 코드가 예외를 발생시킬 때 사용
        - try { try { } catch(e: Exception) { } }catch(e: Exception) { }

    * Throw Keyword
        - 분명한 예외를 던지는 데 사용
        - 커스텀 예외를 던지는데 도 사용 즉, 예외 객체를 던지는데 사용
        - 앱을 고장나게 하므로 많은 "throw"는 사용하지 말아야함

 */

fun main() {

    /** 예외 처리가 없는 예제 **/
    var str = getNumber("10")
    println(str)

    /** 예외 처리가 발생 예제 **/
    var str2 = getNumber("10.5")
    println(str2)

    /** Multiple catch Block Example **/
    try {
        var a = IntArray(5)
        a[5] = 10 / 0
    } catch (e: ArithmeticException) {
        println("arithmetic exception catch")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("array index out of bounds exception")
    } catch (e : Exception) {
        println("parent exception class")
    }

    /** Finally Block Exception **/
    try {
        val data = 10 / 5
        println(data)
    } catch (e: NullPointerException) {
        println(e)
    } finally {
        println("finally block always executes")
    }
    println("below code...")

    /** Throw Keyword **/
    validate(15)
    println("code after validation check") // 이미 예외가 발생했기 때문에 실행되지 않음

}

/** 예외 처리 예제 함수 **/
fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)// 정수 10으로 변환
    } catch (e: ArithmeticException) {
        0
    }
}

/** Throw Keyword 예제 함수 **/
fun validate(age: Int) {
    if(age < 18) {
        throw ArithmeticException("Under age")
    } else {
        println("eligible for drive")
    }
}

