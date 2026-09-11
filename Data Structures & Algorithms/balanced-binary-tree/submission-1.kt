/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
import kotlin.math.abs
class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        var isBalanced = true
        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            val leftHeight = dfs(root.left)
            val rightHeight = dfs(root.right)
            if (abs(leftHeight - rightHeight) > 1) {
                isBalanced = false
            }
            return maxOf(leftHeight, rightHeight) + 1
        }
        dfs(root)
        return isBalanced
    }
}
