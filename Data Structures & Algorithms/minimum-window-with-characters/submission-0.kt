class Solution {
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) return ""

        val need = HashMap<Char, Int>()
        for (c in t) {
            need[c] = need.getOrDefault(c, 0) + 1
        }

        val window = HashMap<Char, Int>()
        var have = 0
        val needCount = need.size
        var res = Pair(-1, -1)
        var resLen = Int.MAX_VALUE

        var left = 0
        for (right in s.indices) {
            val c = s[right]
            window[c] = window.getOrDefault(c, 0) + 1

            if (need.containsKey(c) && window[c] == need[c]) {
                have++
            }

            while (have == needCount) {
                if (right - left + 1 < resLen) {
                    res = Pair(left, right)
                    resLen = right - left + 1
                }

                val leftChar = s[left]
                window[leftChar] = window[leftChar]!! - 1
                if (need.containsKey(leftChar) && window[leftChar]!! < need[leftChar]!!) {
                    have--
                }
                left++
            }
        }

        return if (resLen == Int.MAX_VALUE) "" else s.substring(res.first, res.second + 1)
    }
}
