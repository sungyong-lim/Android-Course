fun main() {

    // null 허용 변수 생성
    var name: String? = "Lim"

    // 고전적인 방법
    if(name != null) {
        println(name.length)
    } else {
        null
    }

    // 코틀린 방법
    // name이 null이 아니라면 len에 name에 length를 할당하고 만약 null 이라면 len에 null을 할당
    var len = name?.length
    println(len)

    // 안전한 호출 방법 -> let
    name?.let { println(it.length) }


}