package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode
import java.util.*

/**
 * Desc:
 *
 * # 112. Path Sum(路径总和)
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *           5
 *          / \
 *         4   8
 *        /   / \
 *      11  13  4
 *     /  \      \
 *    7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-07-01
 */


class PathSum: StringSpec({

    "Path Sum" {
        TreeNode(5)
                .left(TreeNode(4).left(TreeNode(11, 7, 2)))
                .right(TreeNode(8).left(13).right(TreeNode(4, null, 1)))
                .hasPathSum(22) shouldBe true

        TreeNode(5)
                .left(TreeNode(4).left(TreeNode(11, 7, 2)))
                .right(TreeNode(8).left(13).right(TreeNode(4, null, 1)))
                .hasPathSum2(22) shouldBe true
    }
})

/**
 * 深度优先遍历, 缺点改变了数的结构
 */
private fun TreeNode?.hasPathSum(target: Int): Boolean {
    this ?: return false

    // 前序遍历
    // 可以使用 Pair 以保证节点的值不变
    val stack = ArrayDeque<TreeNode>().also { it.push(this) }
    while (!stack.isEmpty()) {
        val node = stack.pop()
        // 修改左右节点的值, 入栈
        if (node.right != null) {
            node.right!!.`val` += node.`val`
            stack.push(node.right)
        }
        if (node.left != null) {
            node.left!!.`val` += node.`val`
            stack.push(node.left)
        }
        // 处理节点
        if (node.right == null && node.left == null) {
            if (node.`val` == target) {
                return true
            }
        }
    }
    return false
}

// 递归
private fun TreeNode?.hasPathSum2(target: Int): Boolean {
    this ?: return false

    if (this.left == null && this.right == null) {
        return target == this.`val`
    }

    return this.left.hasPathSum2(target - this.`val`) || this.right.hasPathSum2(target - this.`val`)
}