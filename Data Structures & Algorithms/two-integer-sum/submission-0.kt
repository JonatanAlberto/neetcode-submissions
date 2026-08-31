class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        for (i in nums.indices) {
            val currI = nums[i]
            for (j in i + 1 until nums.size) {
                val currJ = nums[j]
                if (currI + currJ == target) {
                    result[0] = i
                    result[1] = j
                    return result
                }
            }
        }
        return result
    }
}
