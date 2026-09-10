/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val map = HashMap<Node, Node?>()
        var newHead: Node? = null
        var current = head
        var newCurrent: Node? = null
        while (current != null) {
            val aux = Node(current.`val`)
            newCurrent?.next = aux
            map[current] = aux
            newCurrent = aux
            if (newHead == null) {
                newHead = newCurrent
            }
            current = current.next
        }
        current = head
        while (current != null) {
            newCurrent = map[current]
            val random = map[current.random]
            newCurrent?.random = random
            current = current.next
        }
        return newHead
    }
}
