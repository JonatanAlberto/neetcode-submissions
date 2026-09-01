class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val n = position.size
        if (n == 0) return 0

        val cars = Array(n) { i ->
            Pair(position[i], (target - position[i]).toDouble() / speed[i])
        }

        cars.sortBy { it.first }

        val stack = Stack<Double>()
        stack.push(cars[n - 1].second)
        for (i in n - 2 downTo 0) {
            val time = cars[i].second
            if (time > stack.peek()) {
                stack.push(time)
            }
        }

        return stack.size
    }
}
