package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode
import java.util.*

/**
 * Desc:
 *
 * 145. Binary Tree Postorder Traversal (二叉树的后序遍历)
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-26
 */

class  BinaryTreePostorderTraversal : StringSpec({

    "Binary Tree Preorder Traversal" {
        TreeNode(1, null)
                .right(TreeNode(2, 3))
                .postorderTraversal() shouldBe listOf(3, 2, 1)
    }


})

private fun TreeNode?.postorderTraversal(): List<Int> {
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
                stack.push(node to GREY)
                stack.push(node.right to WHITE)
                stack.push(node.left to WHITE)
            }
            GREY -> {
                values.add(node.`val`)
            }
        }
    }

    return values
}
