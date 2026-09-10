/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var first = head
        var second = head
        for (i in 1..n) {
            first = first?.next
        }
        // If the first is null, we reached the end of the list after
        // moving n steps, meaning the head itself should be removed
        if (first == null) {
            return head?.next
        }
        while (first?.next != null) {
            first = first.next
            second = second?.next
        }
        second?.next = second?.next?.next
        return head
    }
}
