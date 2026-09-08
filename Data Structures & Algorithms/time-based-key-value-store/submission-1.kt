class TimeMap() {
 val map = HashMap<String, MutableList<Pair<Int, String>>>()
    fun set(key: String, value: String, timestamp: Int) {
        map.computeIfAbsent(key) { mutableListOf() }.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val list = map[key]
        if (list.isNullOrEmpty()) return ""
        var left = 0
        var right = list.size - 1
        var result = -1 to ""
        while (left <= right) {
            val mid = (left + right) / 2
            if (list[mid].first <= timestamp) {
                if (result.first < list[mid].first) {
                    result = list[mid]
                }
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return result.second
    }
}
