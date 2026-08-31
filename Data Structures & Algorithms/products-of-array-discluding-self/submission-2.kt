class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val output = IntArray(n)

        var prefix = 1
        for (i in 0 until n) {
            output[i] = prefix
            prefix *= nums[i]
        }

        var suffix = 1
        for (i in n - 1 downTo 0) {
            output[i] *= suffix
            suffix *= nums[i]
        }

        return output
    }
}
