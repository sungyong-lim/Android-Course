// 부모 클래스 = 슈퍼 클래스 = 베이스 클래스
// sealed => 상속을 원치 않을 시 사용하는 키워드
open class Cars(val name: String, val brand: String) {

    open var range = 0.0

    fun extendRange(amount: Double) {
        if(amount > 0)
            range += amount
    }

    open fun drive(distance: Double) {
        println("Drove for $distance KM")
    }

}

//자식 클래스 = 파생 클래스 = 서브 클래스
class ElectricCar(name: String, brand: String, batteryLife: Double) : Cars(name, brand) {

    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        println("Drove for $distance KM")

    }

    fun drive() {
        println("Drove for $range KM")
    }
}

fun main() {
    var audi = Cars("a3", "audi")
    var bmw = ElectricCar("m5", "bwm", 85.0)



    // 다형성 = 비슷한 특성을 가진 객체들이 공통된 방법으로 여거지는 것
    audi.drive(85.0)
    bmw.drive(85.0)

}