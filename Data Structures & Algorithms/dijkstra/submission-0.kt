class Solution {
    fun shortestPath(n: Int, edges: List<List<Int>>, src: Int): Map<Int, Int> {
        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((u, v, w) in edges) {
            graph[u].add(v to w)
        }
        val map = HashMap<Int, Int>()
        for (i in 0 until n) {
            map[i] = Int.MAX_VALUE
        }
        map[src] = 0

        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
        pq.add(src to 0)

        while (pq.isNotEmpty()) {
            val (u, d) = pq.poll()
            if (d > map[u]!!) continue

            for ((v, w) in graph[u]) {
                if (map[u]!! + w < map[v]!!) {
                    map[v] = map[u]!! + w
                    pq.add(v to map[v]!!)
                }
            }
        }
        map.filter { it.value == Int.MAX_VALUE }.forEach { (key, value) ->
            map[key] = -1
        }
        return map
    }
}
