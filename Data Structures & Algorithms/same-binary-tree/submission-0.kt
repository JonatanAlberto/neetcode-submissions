/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        var isSame = true
        fun dfs(rootP: TreeNode?, rootQ: TreeNode?) {
            if (rootP == null || rootQ == null) {
                if (rootP?.`val` != rootQ?.`val`) {
                    isSame = false
                }
                return
            }
            dfs(rootP.left, rootQ.left)
            dfs(rootP.right, rootQ.right)
            if (rootP.`val` != rootQ.`val`) {
                isSame = false
            }
        }
        dfs(p, q)
        return isSame
    }
}
