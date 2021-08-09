package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * # 111. Minimum Depth of Binary Tree(二叉树的最小深度)
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * 返回它的最小深度 2.
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-07-01
 */


class MinimumDepthOfBinaryTree: StringSpec({

    "Minimum Depth of Binary Tree" {
        TreeNode(3)
                .left(9)
                .right(TreeNode(20, 15, 7))
                .minDepth() shouldBe 2

        TreeNode(1, 2, null).minDepth() shouldBe 2
    }

})

private fun TreeNode?.minDepth(prev: Int = 0): Int {
    this ?: return 0

    // 需要判断左右子树为null的情况
    val leftMin = this.left.minDepth(prev + 1)
    val rightMin = this.right.minDepth(prev + 1)
    if (this.left == null) {
        return rightMin + 1
    }
    if (this.right == null) {
        return leftMin + 1
    }

    return Math.min(leftMin, rightMin) + 1
}

