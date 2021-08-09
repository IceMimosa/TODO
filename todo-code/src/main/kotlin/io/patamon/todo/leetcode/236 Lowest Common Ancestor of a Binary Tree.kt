package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * # 236. Lowest Common Ancestor of a Binary Tree (二叉树的最近公共祖先)
 *
 * 与 [[LowestCommonAncestorOfBinarySearchTree]] 类似
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-25
 */
class LowestCommonAncestorOfBinaryTree : StringSpec({

    "Lowest Common Ancestor of a Binary Tree" {
        TreeNode(6)
                .left(
                        TreeNode(2).left(0).right(TreeNode(4, 3, 5))
                )
                .right(TreeNode(8, 7, 9))
                .lowestCommonAncestor(TreeNode(2), TreeNode(8))?.`val` shouldBe 6
        TreeNode(3)
                .left(
                        TreeNode(5).left(6).right(TreeNode(2, 7, 4))
                )
                .right(TreeNode(1, 0, 8))
                .lowestCommonAncestor(TreeNode(5), TreeNode(1))?.`val` shouldBe 3

    }

})


/**
 * 递归
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
private fun TreeNode?.lowestCommonAncestor(p: TreeNode?, q: TreeNode?): TreeNode? {
    if (this == null || this.`val` == p!!.`val` || this.`val` == q!!.`val`) {
        return this
    }

    val left = this.left.lowestCommonAncestor(p, q)
    // 剪枝
    if (left != null && left.`val` != p.`val` && left.`val` != q.`val`) {
        return left
    }

    val right = this.right.lowestCommonAncestor(p, q)
    if (left != null && right != null) {
        return this
    }
    return left ?: right
}

// TODO: 其他方式: DFS 记录父节点