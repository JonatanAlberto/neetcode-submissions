/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        invert(root)
        return root
    }

    private fun invert(node: TreeNode?) {
        if (node == null) return
        invert(node.left)
        invert(node.right)
        val aux = node.left
        node.left = node.right
        node.right = aux
    }
}
