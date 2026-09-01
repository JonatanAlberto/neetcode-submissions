class MinStack() {
    class Stack {
        var value: Int? = null
        var previous: Stack? = null
        var next: Stack? = null
    }

    var head: Stack? = null
    var minStack: Stack? = null

    fun push(`val`: Int) {
        val current = Stack()
        current.next = head
        current.value = `val`
        head = current
        if (minStack == null) {
            minStack = Stack()
            minStack?.value = `val`
        } else if (minStack!!.value!! >= `val`) {
            val min = Stack()
            min.value = `val`
            min.next = minStack
            minStack?.previous = min
            minStack = min
        }
    }

    fun pop() {
        if (head!!.value == minStack!!.value!!) {
            minStack = minStack?.next
            minStack?.previous = null
        }
        head = head?.next
    }

    fun top(): Int {
        return head!!.value!!
    }

    fun getMin(): Int {
        return minStack!!.value!!
    }
}
