fun main() {
    var user = Car()
    println(user.owner)

    println(user.myBrand)

    user.maxSpeed = -5
    println(user.maxSpeed) // Custom Setter에 if 문 때문에 오류 출력

//    user.myModel = "M3"  //  Private 이기 때문에 변경 불가능
    println(user.myModel) //init에서 "M3" 로 변경했기 때문에 M3 출력
}

class Car() {
    // lateinit = 지연 초기화 = 나중에 최기화 예정 의미
    lateinit var owner: String

    var myBrand = "BWM"
        // Custom getter
        get() {
            return field.toLowerCase()
        }

    var maxSpeed = 250
        // field = getter와 setter 메서드 안에서 프로퍼티 참조를 도와주며 뒷받침하는 필드
        get() = field // getter field는 Custom field가 아님

        set(value) {
            // 최고 속도(maxSpeed)를 0 이하로 정할 시 오류 출력
            field = if(value > 0) value else throw IllegalArgumentException("MaxSpeed cannot be less than 0")
        }
    var myModel = "M5"
        // private 이기 때문에 한 클래스 내에서만 모델의 값을 변경할 수 있음
        // 단 getter 는 가능 getter 는 비공개가 아니기 때문임
        private set

    init {
        this.myModel = "M3" // M3 출력
        this.owner = "Lim"
    }
}