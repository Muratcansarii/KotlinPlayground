

fun aVeryBigSum(ar: Array<Long>): Long {
    var result = 0L
    for(element in ar) {
        result += element
    }
    return result
}