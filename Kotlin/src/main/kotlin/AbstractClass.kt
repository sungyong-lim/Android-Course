/** 추상 클래스 **/
/*
    - 추상 클래스에서 프로퍼티와 메서드 같은 멤버 변수는 키워드 abstract를 사용하지 않는 한 추상적인 것은 아님
*/

/** 추상클래스와 인터페이스 차이점 **/
/*
    - 인터페이스는 state를 저장할 수 없고, 여러 인터페이스를 구현할수 있지만 추상 클래스는 한 개만 구현 가능
      서브클래스는 여러 인터페이스를 상속할 수 있지만 추상 클래스는 하나만 상속 가능
    - 인터페이스는 생성자가 없고 추상 클래스는 생성자가 존재
    - 인터페이스는 필드를 저장하지 못함. 추상 클래스는 인터페이스가 추가할 수 있는 건 모두 할 수 있고 필드와 생성자도 추가할 수 있음
    -
*/

//추상 클래스 Mammal 에는 이름, 출신, 무게가 들어간 주생성자가 있다. 추상적이지 않고 구체적임
abstract class Mammal(private val name: String, private val origin: String, private val weight: Double) {
    // maxSpeed는 추상 프로퍼티 -> 이는 꼭 서브 클래스가 오버라이딩 해야함
    abstract var maxSpeed: Int

    // abstract 를 추가해 run 추상메서드 구현 -> 바디 없이 생성 가능
    // 서브 클래스가 오버라이딩 해야함
    abstract fun run()

    // abstract 를 추가해 breath 추상메서드 구현 -> 바디 없이 생성 가능
    // 서브 클래스가 오버라이딩 해야함
    abstract fun breath()
}

// 상속할려면 상위 클래스의 모든 추상 클래스(메서드, 프로퍼티)를 오버라이딩 해야함
class Human(name: String, origin: String, weight: Double, override var maxSpeed: Int) : Mammal(name, origin, weight) {
    override fun run() = println("Run on two legs")

    override fun breath() = println("Breath through mouth or nose")

}

// 상속할려면 상위 클래스의 모든 추상 클래스(메서드, 프로퍼티)를 오버라이딩 해야함
class Tiger(name: String, origin: String, weight: Double, override  var maxSpeed: Int) : Mammal(name,origin,weight) {
    override fun run() = println("Run on four legs")

    override fun breath() = println("Breath through the trunk")
}

fun main() {
    // 추상클래스는 객체를 생성할 수 없다
    // var mammal = Mammal("a","kr",80.0)

    // 상속받는 클래스에는 가능
    var human = Human("lim","kr",80.0,30)
    var tiger = Tiger("Tiger", "usa", 120.0,100)

    human.run()
    tiger.run()

    human.breath()
    tiger.breath()
}