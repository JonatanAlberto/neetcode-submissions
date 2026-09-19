/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return if (root == null || p == null || q == null) null
        else if (p.`val` > q.`val`) lowestCommonAncestor(root, q, p)
        else if (p.`val` == root.`val` || q.`val` == root.`val`) {
            // If one of the search are the root, the root is the LCA
            root
        } else if (p.`val` < root.`val` && q.`val` > root.`val`) {
            // In this case we have an split that mean tha LCA is the root
            root
        } else {
            // Now we need to check were we need to go
            if (p.`val` < root.`val`) {
                lowestCommonAncestor(root.left, p, q)
            } else {
                lowestCommonAncestor(root.right, p, q)
            }
        }
    }
}
