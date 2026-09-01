class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var rowLeft = 0
        var rowRight = matrix.size - 1
        while (rowLeft <= rowRight) {
            // First check the first value of the middle row to see if the equal, greater or smaller of the target
            val midRow = (rowLeft + rowRight) / 2
            val endCol = matrix[midRow].size - 1
            if (matrix[midRow][0] <= target && matrix[midRow][endCol] >= target) {
                // Correct row, interact with columns
                var colLeft = 0
                var colRight = endCol
                while (colLeft <= colRight) {
                    var midCol = (colLeft + colRight) / 2
                    if (matrix[midRow][midCol] == target) {
                        return true
                    } else if (matrix[midRow][midCol] > target) {
                        colRight = midCol - 1
                    } else {
                        colLeft = midCol + 1
                    }
                }
                return false
            } else if (matrix[midRow][0] > target) {
                rowRight = midRow - 1
            } else if (matrix[midRow][endCol] < target) {
                rowLeft = midRow + 1
            }
        }
        return false
    }
}
