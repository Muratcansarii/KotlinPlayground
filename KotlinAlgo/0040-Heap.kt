package data_structures

import java.lang.IndexOutOfBoundsException
import java.util.*
import kotlin.collections.ArrayList

private const val EMPTY_HEAP_EXCEPTION = "heap is empty!"

class Heap {
    private var array = ArrayList<Int>()
    private var count: Int = 0
        get() = array.size

    fun insert(value: Int) {
        array.add(value)
        siftUp(count - 1)
    }

    private fun siftUp(index: Int) {
        var parent = getParent(index)
        var child = index
        while (array[parent] > array[child] && child > 0) {
            Collections.swap(array, parent, child)
            child = parent
            parent = getParent(child)
        }
    }

    fun remove(): Int {
        if(count < 0) {
            throw IndexOutOfBoundsException(EMPTY_HEAP_EXCEPTION)
        }

        Collections.swap(array, 0, count - 1)
        val item = array.removeAt(count - 1)
        siftDown(0)
        return item
    }

    private fun siftDown(index: Int) {
        var parent = index

        while(true) {
            var left = getLeftChild(parent)
            var right = getRightChild(parent)
            var canidate = parent

            if(left < count && array[left] < array[canidate]) {
                canidate = left
            }

            if(right < count && array[right] < array[canidate]) {
                canidate = right
            }

            if(parent == canidate) {
                return
            }

            Collections.swap(array, parent, canidate)
            parent = canidate
        }
    }

    fun toSortedList(): List<Int> {
        var list = mutableListOf<Int>()
        for(i in 0 until count) {
            list.add(remove())
        }
        return list
    }

    private fun getParent(index: Int): Int {
        return (index - 1) / 2
    }

    private fun getLeftChild(index: Int): Int {
        return (index * 2) + 1
    }

    private fun getRightChild(index: Int): Int {
        return (index * 2) + 2
    }
}