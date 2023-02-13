
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        return when {
            lists.isEmpty() -> null
            lists.size == 1 -> lists.first()
            else -> lists.reduce {
                l1, l2 -> merge2Lists(l1, l2)
            }
        }
    }

    private fun merge2Lists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null || l2 == null) {
            return l1 ?: l2
        }
        return if (l1.`val` < l2.`val`) {
            l1.next = merge2Lists(l1.next, l2)
            l1
        } else {
            l2.next = merge2Lists(l1, l2.next)
            l2
        }
    }
}