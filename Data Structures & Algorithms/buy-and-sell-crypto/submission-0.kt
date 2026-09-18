class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        var buy = -1
        var sell = prices[n - 1]
        var profit = 0
        for (i in n - 2 downTo 0) {
            var current = prices[i]
            if (sell < current) {
                sell = current
            } else if (sell - current > profit) {
                buy = current
                profit = sell - buy
            }
        }
        return profit
    }
}
