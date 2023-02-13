

fun birthdayCakeCandles(candles: Array<Int>): Int {
    var result = 0
    var maxHeight = -1
    for (c in candles) {
        if (c > maxHeight) {
            result = 1
            maxHeight = c
        } else if (c == maxHeight) {
            result++
        }
    }
    return result
}