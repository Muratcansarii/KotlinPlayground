// murat loves kotlin 
fun miniMaxSum(arr: Array<Int>): Unit {
    var minValue = Long.MAX_VALUE
    var maxValue = Long.MIN_VALUE
    for (index in arr.indices) {
        var tempValue = 0L
        for (subIndex in arr.indices) {
            if (index != subIndex) {
                tempValue += arr[subIndex].toLong()
            }
        }
        minValue = Math.min(tempValue, minValue)
        maxValue = Math.max(tempValue, maxValue)
    }
    println("$minValue $maxValue")
}