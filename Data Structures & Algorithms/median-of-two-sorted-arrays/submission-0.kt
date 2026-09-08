class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
// nums1 should be smaller or equal than nums2, so if not, change the sequence
        if (nums1.size > nums2.size) return findMedianSortedArrays(nums2, nums1)
        val m = nums1.size
        val n = nums2.size
        var left = 0
        var right = m
        while (left <= right) {
            val partition1 = (left + right) / 2 // partition1 = x
            val partition2 = (m + n + 1) / 2 - partition1 // half = (m + n + 1)/2

            // To avoid IndexOutOfBounds, if the array don't have elements on each side, just add a safe-guard value
            val maxLeft1 = if (partition1 == 0) Int.MIN_VALUE else nums1[partition1 - 1]
            val minRight1 = if (partition1 == m) Int.MAX_VALUE else nums1[partition1]
            val maxLeft2 = if (partition2 == 0) Int.MIN_VALUE else nums2[partition2 - 1]
            val minRight2 = if (partition2 == n) Int.MAX_VALUE else nums2[partition2]

            // Checking if the partition is valid, all the left elements (nums1) are smaller than right elements (nums2)
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If the array size (combined) if even we should get two values
                return if ((m + n) % 2 == 0) {
                    (maxOf(maxLeft1, maxLeft2) + minOf(minRight1, minRight2)) / 2.0
                } else {
                    maxOf(maxLeft1, maxLeft2).toDouble()
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1
            } else {
                left = partition1 + 1
            }
        }
        
        // Arrays not sorted correctly
        return -1.0
    }
}
