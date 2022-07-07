package quiz

// 클래스와 오브젝트 퀴즈

fun main() {

    var user1 = MobliePhone("IOS", "Iphone", "11 Pro")
    var user2 = MobliePhone("Android", "SamSung", "Galaxy S20 Ultra")
    var user3 = MobliePhone("Android", "Samsung", "Galaxy z flip 3")
}

class MobliePhone(osName: String, brand: String, model: String){
    init {
        println("OSName: $osName, Brand: $brand, Model: $model")
    }
}