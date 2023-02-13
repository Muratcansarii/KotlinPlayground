fun removeNodes(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    val list = generateSequence(head) { it.next }.map { it.`val` }.toMutableList()
    val reversed = list.asReversed()
    val reversedIt = reversed.iterator()
    var maxElement = 0
    while (reversedIt.hasNext()) {
        val current = reversedIt.next()
        if (current < maxElement) {
            reversedIt.remove()
        } else {
            maxElement = current
        }
    }

    return list.toListNodes()
}
//megadeth dinlerken iyi gidio