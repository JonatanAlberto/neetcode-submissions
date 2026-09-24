/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty() || preorder.size != inorder.size) return null
        val map = HashMap<Int, Int>()
        for ((index, value) in inorder.withIndex()) {
            map[value] = index
        }

        var preIndex = 0

        fun arrayToTree(left: Int, right: Int): TreeNode? {
            if (left > right) return null

            val rootVal = preorder[preIndex++]
            val root = TreeNode(rootVal)

            val inIndex = map[rootVal]!!
            root.left = arrayToTree(left, inIndex - 1)
            root.right = arrayToTree(inIndex + 1, right)
            
            return root
        }

        return arrayToTree(0, inorder.size - 1)
    }
}
