/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 1) return head

        val dummy = ListNode(0)
        dummy.next = head
        var prevGroupEnd: ListNode? = dummy

        while (true) {
            // Check if has K nodes remaining
            var kth = prevGroupEnd
            for (i in 0 until k) {
                kth = kth?.next
                if (kth == null) return dummy.next
            }

            val groupStart = prevGroupEnd?.next
            val groupNext = kth?.next

            // Revert the group [groupStart..kth]
            var prev: ListNode? = groupNext
            var curr = groupStart
            while (curr != groupNext) {
                val tmp = curr?.next
                curr?.next = prev
                prev = curr
                curr = tmp
            }

            // Connect the groups
            prevGroupEnd?.next = prev
            prevGroupEnd = groupStart
        }
    }
}
