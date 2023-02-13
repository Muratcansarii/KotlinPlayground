package data_structures

import java.lang.StringBuilder

class LinkedList<T> : Collection<T>{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    public override var size: Int = 0
        private set

    private class Node<T>(var value: T) {
        var next: Node<T>? = null
    }

    fun add(element: T) {
        val newNode = Node<T>(element)
        if(head == null && tail == null) {
            head = newNode
            tail = newNode
        }

        tail?.next = newNode
        tail = newNode
        size++
    }

    fun remove(index: Int): T? {
        if(size == 0) {
            throw NoSuchElementException()
        }

        var old = head
        for(i in 0 until index) {
           old = old?.next
        }

        val value = old?.value
        var newNode = old?.next
        old?.value = newNode?.value!!
        old?.next = newNode.next
        return value
    }

    fun removeFirst(): T {
        if(size == 0) {
            throw NoSuchElementException()
        }

        val old = head!!
        head = old.next
        size--
        return old.value
    }

    fun get(index: Int): T {
        var node = head
        for(i in 0 until index) {
            node = node?.next
        }
        return node?.value!!
    }

    override fun contains(element: T): Boolean {
        for(obj in this) {
            if(obj == element) {
                return true
            }
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for(element in elements) {
            if(!contains(element)) {
                return false
            }
        }
        return true
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        var stringBuilder = StringBuilder()
        stringBuilder.append("[")
        for(obj in this) {
            stringBuilder.append(obj.toString() + ",")
        }
        stringBuilder.deleteCharAt(stringBuilder.length - 1)
        stringBuilder.append("]")
        return stringBuilder.toString()
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var node = head
            override fun hasNext(): Boolean {
                return node != null
            }

            override fun next(): T {
                if(!hasNext()) throw NoSuchElementException()
                val current = node!!
                node = current.next
                return current.value
            }
        }
    }
}