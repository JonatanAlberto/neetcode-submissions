/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slowPointer = head
        var fastPointer = head?.next

        while (fastPointer != null && slowPointer != null) {
            if (slowPointer == fastPointer) { return true }
            slowPointer = slowPointer.next
            fastPointer = fastPointer.next?.next
        }
        return false
    }
}
