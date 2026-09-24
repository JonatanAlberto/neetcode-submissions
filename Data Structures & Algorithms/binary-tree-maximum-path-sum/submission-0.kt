/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        var maxSum = Int.MIN_VALUE

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val leftGain = maxOf(dfs(node.left), 0)
            val rightGain = maxOf(dfs(node.right), 0)

            val currentPath = node.`val` + leftGain + rightGain
            maxSum = maxOf(maxSum, currentPath)

            return node.`val` + maxOf(leftGain, rightGain)
        }

        dfs(root)
        return maxSum
    }
}
