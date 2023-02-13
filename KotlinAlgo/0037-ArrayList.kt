package data_structures

class ArrayList {
    private var capacity = 20
    private var size = 0
    private var array: IntArray = IntArray(20)

    fun toList(): List<Int> =
        array.slice(0 until size)

    fun find(element: Int): Boolean {
        for(i in array) {
            if(i == element)
                return true
        }

        return false
    }

    fun add(element: Int) {
        if(size == capacity) {
            resize()
        }

        array[size] = element
        size++
    }

    private fun resize() {
        capacity *= 2
        var temp = IntArray(capacity)
        for((index, value) in array.withIndex()) {
            temp[index] = value
        }
        array = temp
    }

    fun remove(element: Int): Boolean {
        val index = search(element)
        if(element == -1) return false

        shiftLeft(index)
        size--
        return true
    }

    private fun search(element: Int): Int {
        for ((index, value) in array.withIndex()) {
            if(value == element) {
                return index
            }
        }
        return -1
    }

    private fun shiftLeft(index: Int) {
        for (i in index until size) {
            array[i] = array[i + 1]
        }
    }

    fun insert(index: Int, element: Int) {
        if(capacity == size) {
            resize()
        }

        size++
        shiftRight(index + 1)
        array[index] = element
    }

    private fun shiftRight(index: Int) {
        for(i in size + 1 downTo index) {
            array[i] = array[i - 1]
        }
    }
}