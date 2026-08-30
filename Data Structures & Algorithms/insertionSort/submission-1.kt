// Definition for a pair
// class Pair(var key: Int, var value: String)

class Solution {
    fun insertionSort(pairs: MutableList<Pair>): List<List<Pair>> {
        if (pairs.isEmpty()) return emptyList()
        val states = mutableListOf<List<Pair>>()
        val arr = pairs.toMutableList()

        // estado inicial
        states.add(arr.toList())

        for (i in 1 until arr.size) {
            val key = arr[i]
            var j = i - 1

            // mover elementos maiores que key uma posição à frente
            while (j >= 0 && arr[j].key > key.key) {
                arr[j + 1] = arr[j]
                j--
            }
            arr[j + 1] = key

            // salvar estado após cada inserção
            states.add(arr.toList())
        }

        return states
    }
}
