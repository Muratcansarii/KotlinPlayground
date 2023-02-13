
import java.util.Stack
class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }
        var num = k
        var first = head
        var last = head
        while (--num > 0 && last != null) {
            last = last.next
        }
        if (last != null) {
            var nextHead = last.next
            val stack = Stack<ListNode>()
            while (first != last) {
                stack.push(first)
                first = first?.next
            }
            while (stack.isNotEmpty()) {
                last?.next = stack.pop()
                last = last?.next
            }
            last?.next = reverseKGroup(nextHead, k)
        }
        return first
    }

}