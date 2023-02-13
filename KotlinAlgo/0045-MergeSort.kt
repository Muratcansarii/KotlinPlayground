//kotlin neymis yav
fun main (args: Array<String>) {
//    val result = mergeSort(mutableListOf(1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 234, 92))
    val result = mergeSort(mutableListOf(1, 4, 2, 8, 43, 2, 55, 1, 234, 92))
//    val result = mergeSort(mutableListOf(1, 4, 2, 8, 43, 2))
    println("Result merge sort: $result")
}

fun merge(list1: MutableList<Int>, list2: MutableList<Int>): MutableList<Int> {
    val mergeList = mutableListOf<Int>()
    while ((list1.size > 0) && (list2.size > 0)) {
        when {
            list1[0] < list2[0] -> {
                mergeList.add(list1.removeFirst())
            }
            list1[0] > list2[0] -> {
                mergeList.add(list2.removeFirst())
            }
            else -> {
                mergeList.add(list1.removeFirst())
                mergeList.add(list2.removeFirst())
            }
        }
    }
    return (mergeList + list1 + list2) as MutableList<Int>
}

fun mergeSort(list: MutableList<Int>): MutableList<Int>{

    if (list.size == 1) return list
        val splitPoint: Int = list.size / 2
        val left = mergeSort(list.slice(0 until splitPoint).toMutableList())
        val right = mergeSort(list.slice(splitPoint until list.size).toMutableList())
    return merge(left, right)
}