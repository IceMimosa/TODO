package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * # 235. Lowest Common Ancestor of a Binary Search Tree (二叉搜索树的最近公共祖先)
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 最近公共祖先的定义为:
 *   “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *   满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 * 说明:
 *   1. 所有节点的值都是唯一的。
 *   2. p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-25
 */
class LowestCommonAncestorOfBinarySearchTree : StringSpec({

    "Lowest Common Ancestor of a Binary Search Tree" {
        TreeNode(6)
                .left(
                        TreeNode(2).left(0).right(TreeNode(4, 3, 5))
                )
                .right(TreeNode(8, 7, 9))
                .lowestCommonAncestor(TreeNode(2), TreeNode(8))?.`val` shouldBe 6

        TreeNode(6)
                .left(
                        TreeNode(2).left(0).right(TreeNode(4, 3, 5))
                )
                .right(TreeNode(8, 7, 9))
                .lowestCommonAncestorLoop(TreeNode(2), TreeNode(8))?.`val` shouldBe 6
    }

})


/**
 * 递归
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
private fun TreeNode?.lowestCommonAncestor(p: TreeNode?, q: TreeNode?): TreeNode? {
    this ?: return null
    if (p == null) return q
    if (q == null) return p

    // 由于是二叉搜索树
    // 1. 如果 p 和 q 在两边, 或是节点本身
    if ((this.`val` - p.`val`) * (this.`val` - q.`val`) <= 0) {
        return this
    }
    // 2. 左子树
    else if (this.`val` > p.`val`) {
        return this.left.lowestCommonAncestor(p, q)
    }
    // 3. 右子树
    else {
        return this.right.lowestCommonAncestor(p, q)
    }

}


/**
 * 迭代
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
private fun TreeNode?.lowestCommonAncestorLoop(p: TreeNode?, q: TreeNode?): TreeNode? {
    this ?: return null
    if (p == null) return q
    if (q == null) return p

    var node = this

    while (node != null) {
        // 由于是二叉搜索树
        // 1. 如果 p 和 q 在两边, 或是节点本身
        if ((node.`val` - p.`val`) * (node.`val` - q.`val`) <= 0) {
            break
        }
        // 2. 左子树
        else if (node.`val` > p.`val`) {
            node = node.left
        }
        // 3. 右子树
        else {
            node = node.right
        }
    }
    return node
}

