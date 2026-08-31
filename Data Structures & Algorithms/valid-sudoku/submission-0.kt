class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val c = board[i][j]
                if (c != '.') {
                    // construir chaves únicas
                    val rowKey = "$c in row $i"
                    val colKey = "$c in col $j"
                    val boxKey = "$c in box ${i/3}-${j/3}"

                    // se já existe, inválido
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false
                    }
                }
            }
        }
        return true
    }
}
