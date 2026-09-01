class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var maxArea = 0
        val n = heights.size

        for (i in 0..n) {
            val h = if (i == n) 0 else heights[i]
            while (stack.isNotEmpty() && h < heights[stack.peek()]) {
                val height = heights[stack.pop()]
                val width = if (stack.isEmpty()) i else i - stack.peek() - 1
                maxArea = maxOf(maxArea, height * width)
            }
            stack.push(i)
        }

        return maxArea
    }
}
