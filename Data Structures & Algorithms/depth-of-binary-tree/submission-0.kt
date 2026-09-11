/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val deepLeft = maxDepth(root.left)
        val deepRight = maxDepth(root.right)
        return 1 + maxOf(deepLeft, deepRight)
    }
}
