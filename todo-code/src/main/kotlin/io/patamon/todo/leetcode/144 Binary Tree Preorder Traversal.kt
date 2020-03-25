package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode
import java.util.*

/**
 * Desc:
 *
 * 144. Binary Tree Preorder Traversal (二叉树的前序遍历)
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-26
 */

class BinaryTreePreorderTraversal : StringSpec({

    "Binary Tree Preorder Traversal" {
        TreeNode(1, null)
                .right(TreeNode(2, 3))
                .preorderTraversal() shouldBe listOf(1, 2, 3)
    }


})

private fun TreeNode?.preorderTraversal(): List<Int> {
    this ?: emptyList<Int>()

    val WHITE = 0
    val GREY  = 1

    val values = mutableListOf<Int>()
    val stack = ArrayDeque<Pair<TreeNode?, Int>>()
    stack.push(this to WHITE)

    while (stack.isNotEmpty()) {
        val (node, color) = stack.pop()
        if (node == null) continue
        when (color) {
            WHITE -> {
                stack.push(node.right to WHITE)
                stack.push(node.left to WHITE)
                stack.push(node to GREY)
            }
            GREY -> {
                values.add(node.`val`)
            }
        }
    }

    return values
}

// TODO: 莫里斯遍历

