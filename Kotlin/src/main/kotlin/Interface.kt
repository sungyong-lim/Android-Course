// 인터페이스는 모든 프로퍼티와 함수를 구현해줄 수 있지만, 꼭 그래야만 하는 것은 아니다
// 만약 구현된 부분이 있다면 그 인터페이스를 사용하는 클래스가 오버라이딩 할 수 있음
// 예) 인터페이스는 기본적으로 클래스가 서명할 수도 있는 계약서
// 인터페이스는 다른 인터페이스에서 상속받을 수 있음
// 다른 인터페이스에서 상속받는 고유 인터페이스를 만들 수 잇음
// 인터페이스 사용 이유 => 나중에서 구현하고 싶은 특정 함수와 클래스 프로퍼티를 바로 구현하지 않고 싶을 경우 매우 유용
//                          또, 구체적으로 함수 바디를 아직 만들고 싶지 않을 때도 유용

interface Drivable {
    val maxSpeed: Double
    fun drive(): String
    fun brake() {
        println("Brake.....")
    }
}

// 클래스가 인터페이스를 상속 받는 경우
/*
    calss name(override val interfacePropertyName : property returnType, classProperty..) : interfaceName {
        // method에 body가 없는 경우 정의해줘야함
        override fun interfaceMethodName() : returnType {

        }
    }
* */
open class Car1(override val maxSpeed: Double, val name: String, val brand: String) : Drivable {
    // 이 drive 함수는 확장하는 인터페이스에서 오는 것
    override fun drive(): String = "Car Driver"

}

class ElectCar(maxSpeed: Double, name: String, brand: String, battery: Double) : Car1(maxSpeed, name, brand) {

    override fun drive(): String = "ElectCar Driver"

    override fun brake() {
        // super 키워드를 사용하면 인터페이스나 슈퍼 클래스에서 brake에 구현된 것이 실행됨
        // Method를 호출하면 interface의 Brake..... 와 ElectCar Brake.... 가 실행
        super.brake()
        println("ElectCar Brake....")
    }
}

fun main() {
    val a = Car1(200.0, "a3", "audi")
    val b = ElectCar(190.0, "s-model", "benz",85.0)

    println(a.drive())
    println(b.drive())

    a.brake()
    b.brake()



}