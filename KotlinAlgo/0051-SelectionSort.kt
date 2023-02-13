
fun main (args: Array<String>) {
    val result = selectionSort(mutableListOf(1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 234, 92))
    println("Result selection sort: $result")
}

fun selectionSort (list: MutableList<Int>): MutableList<Int> {

    fun swap(index1: Int, index2: Int) {
        val temp = list[index1]
        list[index1] = list[index2]
        list[index2] = temp
    }

    if (list.size < 1) return list

    for (i in 0 until list.size - 1) {
        var min = list[i]
        var minIndex = i
        var isSwap = false
        for (j in (i + 1) until list.size) {
            if (list[j] < min) {
                min = list[j]
                minIndex = j
                isSwap = true
            }
        }
        if (isSwap) {
            swap(i, minIndex)
        }
        println("Step $i, result: $list")
    }

    return list
}