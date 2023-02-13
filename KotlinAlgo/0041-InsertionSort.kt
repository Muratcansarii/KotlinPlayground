

fun main(args: Array<String>) {
    val result = insertionSort(mutableListOf(1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 234, 92))
    println("Result insertion sort: $result")
}

fun insertionSort(list: MutableList<Int>): MutableList<Int> {
    //only one item, return
    if (list.size < 2) return list

    //iterate the list
    for (i in 1 until list.size) {
        val current = list[i]
        var index = i
        var isSwap = false
        for (j in (i - 1) downTo 0) {
            if (list[j] > current) {
                list[j + 1] = list[j]
                index = j
                isSwap = true
            }
        }
        if (isSwap) list[index] = current
    }
    return list
}