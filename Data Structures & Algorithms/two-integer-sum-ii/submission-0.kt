class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var index1 = 0
        var index2 = numbers.size - 1
        while (index1 < index2) {
            val sum = numbers[index1] + numbers[index2]
            if (sum == target) {
                index1++
                index2++
                break
            } else if (sum > target) {
                index2--
            } else {
                index1++
            }
        }
        return intArrayOf(index1, index2)
    }
}
