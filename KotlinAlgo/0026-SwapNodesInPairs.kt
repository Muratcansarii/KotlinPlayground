
class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        var runner = head.next
        head.next = swapPairs(runner.next)
        runner.next = head
        return runner
    }
}