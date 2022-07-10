package Class

// 데이터 클래스 생성
// 데이터클래스는 주생성자가 매개변수 하나는 꼭 있어여함
// 추상, 오픈, 봉인 내부 클래수가 있을 수 없음
data class Users(val id: Long, var name: String)


fun main() {
    // user1 객체 생성
    var user1 = Users(1, "Lim")

    var user2 = Users(1, "Lim")

    println(user1 == user2) // true

    // Copy
    val updateUser1 = user1.copy()  // user1에 내용을 updateUser에 전체 복사
    println(updateUser1)

    val updateUser2 = user2.copy(name="Kim") // user1에 id와 name은 Kim 변경해서 updateUser2에 복사
    println(updateUser2)

    // 컴포넌트 출력
    println("${user1.component1()}, ${user1.component2()}") // 1, Lim

    // 구조 분해
    val (id, name) = updateUser1  // val id = userUpdate.id , val name = userUpdate.name 과 동일
    println("id: $id, name: $name")
}