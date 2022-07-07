package quiz

// For Loop Quiz

fun main() {

    // 1
    for(i in 0..10000) {
        if(i == 9001) {
            println("IT's OVER 9000!!")
        }
    }

    // 2
    var humidityLevel = 80
    var humidity = "humid"

    while (humidity == "humid") {
        humidityLevel -= 5
        println("humidity decreased")
        if( humidityLevel < 60) {
            println("it's comfy now")
            humidity = "comfy"
        }
    }


}