/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
if (head == null || head.next == null) return head
        var newHead: ListNode? = null
        var current = head
        while (current != null) {
            if (newHead == null) {
                newHead = ListNode(current.`val`)
                newHead.next = null
            } else {
                val oldHead = newHead
                newHead = ListNode(current.`val`)
                newHead.next = oldHead
            }
            current = current.next
        }
        return newHead
    }
}
