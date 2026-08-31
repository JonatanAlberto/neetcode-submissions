class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            val freq = map.getOrDefault(num, 0) + 1
            map[num] = freq
        }
        val sorted = map.toList().sortedBy { (_, v) -> v }.reversed().toMap()
        return sorted.keys.take(k).toIntArray()
    }
}
