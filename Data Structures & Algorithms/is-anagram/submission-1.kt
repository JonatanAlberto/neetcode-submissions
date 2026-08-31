class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val map = HashMap<Char, Int>()
        for (c in s) {
            map[c] = (map[c] ?: 0) + 1
        }
        for (c in t) {
            if (map[c] == null || map[c] == 0) return false
            else map[c] = (map[c] ?: 0) - 1
        }
        return true
    }
}
