
fun main (args: Array<String>) {
    val result = quickSort(mutableListOf(1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 234, 92))
    println("Result quick sort: $result")

    val result2 = quickSort2(mutableListOf(1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 234, 92))
    println("Result quick sort2: $result")

}

fun quickSort(list: MutableList<Int>): MutableList<Int> {

    if (list.size < 2) return list

    //store in different list for left, right and equal
    val left = mutableListOf<Int>()
    val equal = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    //pick pivot
    val pivot = list[0]
    equal.add(list[0])
    for (i in 1 until list.size) {
        when {
            list[i] < pivot -> left.add(list[i])
            list[i] > pivot -> right.add(list[i])
            else -> equal.add(list[i])
        }
    }
    return (quickSort(left) + equal + quickSort(right)) as MutableList<Int>
}

/**
 * Swap elements of a list
 */
fun swap(list: MutableList<Int>, index1: Int, index2: Int) {
    if (index1 != index2) {
        val temp = list[index1]
        list[index1] = list[index2]
        list[index2] = temp
    }
}

/**
 * Shift elements with value < pivot -> left
 */
fun pivot(list: MutableList<Int>, left: Int, right: Int): Int {
    var pivotIndex = left
    for (i in left + 1 until right) {
        if (list[i] < list[left]) swap(list, i, ++pivotIndex)
    }

    //swap pivot with left item
    swap(list, left, pivotIndex)
    return pivotIndex
}

/**
 * Keep index of pivot element
 */
fun quickSort2(list: MutableList<Int>, left: Int = 0, right: Int = list.size - 1): MutableList<Int> {

//    val left = inputLeft ?: 0
//    val right = inputRight ?: list.size - 1

    if (right <= left) return list

    val pivotIndex = pivot(list, left, right)
    quickSort2(list, left, pivotIndex - 1)
    quickSort2(list, pivotIndex + 1, right)

    return list
}