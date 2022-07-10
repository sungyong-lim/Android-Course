/** 접근 제한자(Visibility Modifiers) **/
/*
    - 클래스, 인터페이스, 프로퍼티를 제한하는 데 사용하는 키워드
    - 클래스 헤더나 메서드 바디 등 여러 곳에 사용됨
    * 분류
        - public => 기본 제한자, 프로젝트 어디서든 접근 가능
        - private => 프로퍼티, 필드 등이 선언된 블록에서만 요소에 접근이 가능 즉, 스코프 밖으로의 접근을 막음
                     특정 파일 내에서만 접근 가능 즉, 같은 클래스, 같은 파일 안에서만 사용 가능
        - protected => 그 안의 클래스 또는 서브 클래스에서 보이게 함, 최상위에 선언될 수 없음 즉, 패키지는 보호받을 수 없음
        - internal => 시행된 모듈 안에서만 필드가 보이게 함

     * open
        - 코틀린에서 모든 클래스는 자동으로 최종값임 즉, 자동으로 상속받을 수 없다는 것
        - 상속받게 하려면 "open class ClassName{}" open 키워드를 사용해야함
*/

open class Base() {
    var a  = 1 // public => 기본값 아무것도 적지 않으면 자동으로 public 부여됨
    private var b = 2 // private 이기 때문에 Base 클래스 안에서만 사용 가능
    protected open val c = 3 // protected 이기 때문에 Base 클래스와 Base 클래스를 상속받은 서브 클래스에서 사용 가능
    internal val d = 4 // internal 이기 때문에 모듈안에서 접근 가능
    protected  fun e() { // protected 이기 때문에 Base 클래스와 Base 클래스를 상속받은 서브 클래스에서 사용 가능
        println("Protected E.....")
    }
}

class Derived : Base() {
    /*
        - Derived 클래스는 Base 클래스를 상속받고 있기 때문에
        - 프로퍼티 a, c, d 메서드 e에 접근할 수 있다.
        - c가 상속 받을 수 있는 open 프로퍼티이기 때문에 override 가능 하지만 결국에는 protected 이기
          때문에 Base 클래스와 Derived 클래스를 제외하고는 접근할 수 없다.
        - 프로퍼티 b는 private 이기 때문에 Base 클래스를 제외하고는 접근할 수 없다.
    */
    override val c = 9
}

fun main() {

    // base 객체는 Base 클래스에 a, d 만 사용 가능
    // b, c, e 는 접근 불가
    val base = Base()


    // derived 객체는 a, b만 사용 가능
    // b, c, e 접근 불가
    // c를 override 했어도 결국에는 protected 이기 때문임
    val derived = Derived()

}