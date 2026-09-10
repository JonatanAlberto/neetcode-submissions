/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
import java.math.BigInteger
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var current = l1
        var num1 = ""
        var num2 = ""

        while (current != null) {
            num1 += current.`val`.toString()
            current = current.next
        }

        current = l2

        while (current != null) {
            num2 += current.`val`.toString()
            current = current.next
        }

        val result = BigInteger(num1.reversed()) + BigInteger(num2.reversed())
        var head: ListNode? = null

        for (c in result.toString()) {
            val aux = ListNode(c.digitToInt())
            var previous = head
            aux.next = previous
            head = aux
        }

        return head
    }
}
