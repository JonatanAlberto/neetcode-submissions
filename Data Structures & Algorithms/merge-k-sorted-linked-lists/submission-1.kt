/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>(compareBy { it.`val` })

        for (node in lists) {
            if (node != null) pq.add(node)
        }

        val dummy = ListNode(0)
        var tail = dummy

        while (pq.isNotEmpty()) {
            val minNode = pq.poll()
            tail.next = minNode
            tail = tail.next!!

            if (minNode.next != null) {
                pq.add(minNode.next)
            }
        }

        return dummy.next
    }
}
