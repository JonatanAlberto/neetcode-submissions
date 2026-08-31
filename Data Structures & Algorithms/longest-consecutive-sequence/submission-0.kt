class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val sorted = nums.sorted()
        var longCons = 0
        var currCons = 0
        var prev = Int.MAX_VALUE
        for (num in sorted) {
            if (num == prev) continue
            if (prev == Int.MAX_VALUE || num == prev + 1) {
                currCons++
            } else {
                currCons = 1
            }
            prev = num
            if (currCons > longCons) {
                longCons = currCons
            }
        }
        return longCons
    }
}
