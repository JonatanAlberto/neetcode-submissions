class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = ArrayDeque<Int>()
        val result = mutableListOf<Int>()

        for (right in nums.indices) {
            // remover índices fora da janela
            if (deque.isNotEmpty() && deque.first() <= right - k) {
                deque.removeFirst()
            }

            // manter deque em ordem decrescente
            while (deque.isNotEmpty() && nums[deque.last()] < nums[right]) {
                deque.removeLast()
            }

            deque.addLast(right)

            // adicionar máximo da janela atual
            if (right >= k - 1) {
                result.add(nums[deque.first()])
            }
        }

        return result.toIntArray()
    }
}
