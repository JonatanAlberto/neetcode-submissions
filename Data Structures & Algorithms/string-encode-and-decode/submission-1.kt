class Solution {

    fun encode(strs: List<String>): String {
        val encoded = StringBuilder()
        for (s in strs) {
            val size = s.length
            val enc = "$size#$s"
            encoded.append(enc)
        }
        return encoded.toString()
    }

    fun decode(str: String): List<String> {
        val list = mutableListOf<String>()
        var s = ""
        var start = false
        var size = 0
        for (c in str) {
            if (c != '#' && !start) {
                s += c
            } else if (c == '#' && !start) {
                start = true
                size = s.toInt()
                s = ""
            } else if (start && size > 0) {
                size--
                s += c
            }
            if (size == 0 && start) {
                list.add(s)
                start = false
                s = ""
            }
        }
        return list
    }
}
