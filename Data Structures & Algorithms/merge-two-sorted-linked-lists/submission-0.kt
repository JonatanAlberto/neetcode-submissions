/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
var newList: ListNode? = null
        var currentHead: ListNode? = null
        var currentL1 = list1
        var currentL2 = list2
        while (currentL1 != null || currentL2 != null) {
            val useL1 = if (currentL1 != null && currentL2 != null) currentL1.`val` < currentL2.`val`
                    else if (currentL1 != null) true else false
            val aux = ListNode(if (useL1) currentL1!!.`val` else currentL2!!.`val`)
            if (newList == null) {
                newList = aux
                currentHead = newList
            } else {
                currentHead?.next = aux
                currentHead = aux
            }
            if (useL1) currentL1 = currentL1?.next else currentL2 = currentL2?.next
        }
        return newList
    }
}
