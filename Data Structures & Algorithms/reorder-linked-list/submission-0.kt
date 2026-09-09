/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null || head.next == null) return

        // Find the halves
        var slow = head
        var fast = head
        // The slow walks one and the fast walks two
        // When fast is in the end, slow is on the half
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // revert the second half
        var prev: ListNode? = null
        // Get the first value of the second half
        var curr = slow?.next
        // Split the list
        slow?.next = null
        while (curr != null) {
            // Store the next value
            val next = curr.next
            // The next value will be the previous
            curr.next = prev
            // Move the pointer to the "new" first of the second half
            prev = curr
            // Now we will check the next, to continue the reverse
            curr = next
        }
        
        // Build the reorder list
        var first = head
        var second = prev
        while (second != null) {
            val temp1 = first?.next
            val temp2 = second.next
            first?.next = second
            second.next = temp1
            first = temp1
            second = temp2
        }
    }
}
