class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val freq1 = IntArray(26)
        val freq2 = IntArray(26)

        for (c in s1) {
            freq1[c - 'a']++
        }

        for (i in s1.indices) {
            freq2[s2[i] - 'a']++
        }

        if (freq1.contentEquals(freq2)) return true

        for (i in s1.length until s2.length) {
            freq2[s2[i] - 'a']++
            freq2[s2[i - s1.length] - 'a']--
            if (freq1.contentEquals(freq2)) return true
        }

        return false
    }
}
