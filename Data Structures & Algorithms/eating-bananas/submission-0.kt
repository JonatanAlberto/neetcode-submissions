class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.maxOrNull() ?: 1
        var result = right

        while (left <= right) {
            val mid = (left + right) / 2
            var hours = 0L

            for (pile in piles) {
                hours += (pile + mid - 1) / mid
            }

            if (hours <= h) {
                result = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return result
    }
}
