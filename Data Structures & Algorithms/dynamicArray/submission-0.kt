class DynamicArray(capacity: Int) {
    private var currentCapacity = capacity
    private var size = 0
    var array = IntArray(currentCapacity)

    fun get(i: Int): Int {
        return array[i]
    }

    fun set(i: Int, n: Int) {
        array[i] = n
    }

    fun pushback(n: Int) {
        if (getSize() >= currentCapacity) {
            resize()
        }
        array[size] = n
        size++
    }

    fun popback(): Int {
        var n = array[size - 1]
        size--
        return n
    }

    private fun resize() {
        currentCapacity *= 2
        var newData = IntArray(currentCapacity)
        for ((i, element) in array.withIndex()) {
            newData[i] = element
        }
        array = newData
    }

    fun getSize(): Int {
        return size
    }

    fun getCapacity(): Int {
        return currentCapacity
    }
}
