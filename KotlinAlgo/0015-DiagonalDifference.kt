
fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var d1 = 0
    var d2 = 0
    for (i in arr.indices) {
        val subArr = arr[i]
        d1 += subArr[i]
        d2 += subArr[subArr.size - (i + 1)]
    }
    return Math.abs(d1 - d2)
}