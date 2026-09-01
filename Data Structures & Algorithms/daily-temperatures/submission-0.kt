class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size
        val result = IntArray(n)
        val stack = ArrayDeque<Int>()

        for (i in 0 until n) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                val prevIndex = stack.pop()
                result[prevIndex] = i - prevIndex
            }
            stack.push(i)
        }

        return result
    }
}
