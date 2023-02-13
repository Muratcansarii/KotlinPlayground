

fun plusMinus(arr: Array<Int>): Unit {
    val resultArray = arrayOf(0, 0, 0)
    val size = arr.size.toDouble()
    for (index in arr.indices) {
        val value = arr[index]
        if (value > 0) {
            resultArray[0]++
        } else if (value < 0) {
            resultArray[1]++
        } else {
            resultArray[2]++
        }
    }

    println("%.6f".format(resultArray[0] / size))
    println("%.6f".format(resultArray[1] / size))
    println("%.6f".format(resultArray[2] / size))
}