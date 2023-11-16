package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.TreeNode

/**
 * 226. 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
class InvertBinaryTree : BaseSpec({

    "Invert Binary Tree" {
        TreeNode(2, 1, 3)
            .invertTree()
            ?.levelOrder() shouldBe listOf(listOf(2), listOf(3, 1))

        TreeNode(4)
            .left(TreeNode(2, 1, 3))
            .right(TreeNode(7, 6, 9))
            .invertTree()
            ?.levelOrder() shouldBe listOf(listOf(4), listOf(7, 2), listOf(9, 6, 3, 1))
    }
})

private fun TreeNode?.invertTree(): TreeNode? {
    this ?: return this
    if (this.left == null && this.right == null) return this
    val temp = this.left
    this.left = this.right?.invertTree()
    this.right = temp?.invertTree()
    return this
}
