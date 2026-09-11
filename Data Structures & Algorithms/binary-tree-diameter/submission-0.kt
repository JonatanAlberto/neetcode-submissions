/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
         var diameter = 0
        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            val dLeft = dfs(root.left)
            val dRight = dfs(root.right)
            diameter = maxOf(diameter, dLeft + dRight)
            return maxOf(dLeft, dRight) + 1
        }

        dfs(root)
        return diameter
    }
}
