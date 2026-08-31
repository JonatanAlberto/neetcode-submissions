class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        for (s in strs) {
            val freq = IntArray(26)
            for (c in s) {
                freq[c - 'a']++
            }
            val key = freq.joinToString("#")
            map.computeIfAbsent(key) { mutableListOf() }.add(s)
        }
        return map.values.toList()
    }
}
