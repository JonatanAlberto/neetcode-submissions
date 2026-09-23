/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return false
        var isValid = true
        fun dfs(root: TreeNode?, minInterval: Int, maxInterval: Int) {
            if (root == null || !isValid) return
            dfs(root.left, minInterval, root.`val`)
            dfs(root.right, root.`val`, maxInterval)
            if (root.`val` <= minInterval || root.`val` >= maxInterval) isValid = false
        }
        dfs(root, Int.MIN_VALUE, Int.MAX_VALUE)
        return isValid
    }
}
