
fun timeConversion(s: String): String {
    val firstPart = s.take(2)
    val lastPart = s.takeLast(2)
    val rest = s.drop(2).dropLast(2)
    var result = "${firstPart}$rest"
    if (lastPart == "AM") {
        if (firstPart == "12") {
            result = "00$rest"
        }
    } else {
        if (firstPart != "12") {
            result = "${firstPart.toInt() + 12}$rest"
        }
    }
    return result
}
