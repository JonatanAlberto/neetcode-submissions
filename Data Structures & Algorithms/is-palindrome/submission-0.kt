class Solution {
    fun isPalindrome(s: String): Boolean {
        val t = s.replace(Regex("[^A-Za-z0-9]"), "")
        return t.equals(t.reversed(), ignoreCase = true)
    }
}
