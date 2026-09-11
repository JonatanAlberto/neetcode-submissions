class LRUCache(capacity: Int) {
var capacity = capacity
    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0) // dummy head
    private val tail = Node(0, 0) // dummy tail

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.value = value
            moveToHead(node)
        } else {
            val newNode = Node(key, value)
            map[key] = newNode
            addNode(newNode)

            if (map.size > capacity) {
                val tailNode = popTail()
                map.remove(tailNode.key)
            }
        }
    }

    // Helpers
    private fun addNode(node: Node) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }

    private fun removeNode(node: Node) {
        val prev = node.prev
        val next = node.next
        prev?.next = next
        next?.prev = prev
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addNode(node)
    }

    private fun popTail(): Node {
        val res = tail.prev!!
        removeNode(res)
        return res
    }

    private class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }
}
