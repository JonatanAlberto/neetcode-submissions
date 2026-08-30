class LinkedList {
 internal class Structure {
        var value: Int? = null
        var next: Structure? = null
        var previous: Structure? = null
    }

    private var head: Structure? = null

    fun get(index: Int): Int {
        var currentIndex = 0
        var current = head
        while (currentIndex < index && current != null) {
            current = current.next
            currentIndex++
        }
        return current?.value ?: -1
    }

    fun insertHead(value: Int) {
        if (head == null) {
            head = Structure()
            head?.value = value
        } else {
            val oldHead = head
            head = Structure()
            head?.value = value
            head?.next = oldHead
            oldHead?.previous = head
        }
    }

    fun insertTail(value: Int) {
        if (head == null) {
            head = Structure()
            head?.value = value
        } else {
            val tail = Structure()
            tail.value = value
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = tail
            tail.previous = current
        }
    }

    fun remove(index: Int): Boolean {
        if (index == 0) {
            if (head == null) {
                return false
            } else {
                head = head?.next
                head?.previous = null
                return true
            }
        }
        var currentIndex = 0
        var current = head
        var previous = head?.previous
        while (currentIndex < index && current != null) {
            current = current.next
            previous = current?.previous
            currentIndex++
        }
        if (current == null) return false
        else {
            val next = current.next
            previous?.next = next
            next?.previous = previous
            current = null
            return true
        }
    }

    fun getValues(): List<Int> {
        val list = ArrayList<Int>()
        var current = head
        while (current != null) {
            list.add(current.value!!)
            current = current.next
        }
        return list
    }
}
