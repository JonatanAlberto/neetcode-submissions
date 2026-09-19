/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        if (root == null) return list
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            var queueSize = queue.size
            for (i in 0 until queueSize) {
                val node = queue.removeFirst()
                if (node != null) {
                    if (i == queueSize - 1) {
                        list.add(node.`val`)
                    }
                    node.left?.let { queue.add(node.left) }
                    node.right?.let { queue.add(node.right) }
                }
            }
        }
        return list
    }
}
