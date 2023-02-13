

fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    val resultArray = arrayOf(0, 0)
    for (i in a.indices) {
        if (a[i] > b[i]){
            resultArray[0]++
        } else if (b[i] > a[i]) {
            resultArray[1]++
        }
    }
    return resultArray
}