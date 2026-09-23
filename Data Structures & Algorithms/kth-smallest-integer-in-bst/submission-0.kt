/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
         if (root == null) return 0
        var cnt = 0
        var result = -1
        fun dfs(node: TreeNode?) {
            if (node == null || result != -1) return
            dfs(node.left)
            cnt++
            if (cnt == k) {
                result = node.`val`
                return
            }
            dfs(node.right)
        }
        dfs(root)
        return result
    }
}
