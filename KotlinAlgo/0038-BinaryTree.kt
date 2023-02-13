package data_structures

class BinaryTree<T : Comparable<T>> : Collection<T> {

    class Node<T>(var data: T) {
        var left: Node<T>? = null
        var right: Node<T>? = null
    }

    public override var size: Int = 0
        private set
    private var parent: Node<T>? = null

    fun add(data: T) {
        if (parent == null) {
            parent = Node<T>(data)
        } else {
            add(parent!!, data)
        }
        size++
    }

    private fun add(node: Node<T>, data: T) {
        if (data > node.data) {
            if (node.right == null) {
                node.right = Node<T>(data)
            } else {
                add(node.right!!, data)
            }
        } else {
            if (node.left == null) {
                node.left = Node<T>(data)
            } else {
                add(node.left!!, data)
            }
        }
    }

    fun remove(data: T): T {
        size--
        parent = remove(parent, data)
        return parent?.data!!
    }

    private fun remove(node: Node<T>?, data: T): Node<T>? {
        if(node == null) {
            return node
        }

        when {
            data < node.data -> {
                node.left = remove(node.left, data)
            }
            data > node.data -> {
                node.right = remove(node.right, data)
            }
            else -> {
                if(node.left == null) {
                    return node.right
                } else if(node.right == null) {
                    return node.left
                }

                node.data = minNode(node.right)
                node.right = remove(node.right, node.data)
            }
        }

        return node
    }

    private fun minNode(root: Node<T>?) : T {
        var node = root
        while(node?.left != null) {
            node = node?.left
        }
        return node?.data!!
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            if (!contains(element)) {
                return false
            }
        }
        return true
    }

    override fun contains(element: T): Boolean {
        return find(element)
    }

    fun find(data: T): Boolean {
        return find(parent, data)
    }

    private fun find(node: Node<T>?, data: T): Boolean {
        if (node == null)
            return false

        if (node.data == data) {
            return true
        }

        if (data > node.data) {
            return find(node.right, data)
        }
        return find(node.left, data)
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return  preOrderString(parent)
    }

    private fun preOrderString(node: Node<T>?): String {
        if (node == null) {
            return "null"
        }

        return node.data.toString() + "," + preOrderString(node.left) + "," + preOrderString(node.right)
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }
}