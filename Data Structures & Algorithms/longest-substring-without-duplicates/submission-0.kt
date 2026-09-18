class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = HashMap<Char, Int>()
        var left = 0
        var maxLen = 0

        for (right in s.indices) {
            val c = s[right]
            if (seen.containsKey(c) && seen[c]!! >= left) {
                // mover left para depois da última ocorrência
                left = seen[c]!! + 1
            }
            seen[c] = right
            maxLen = maxOf(maxLen, right - left + 1)
        }

        return maxLen
    }
}
