package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode
import java.util.*
import kotlin.math.max

/**
 * Desc:
 *
 * # 104. Maximum Depth of Binary Tree (二叉树的最大深度)
 *
 *  给定一个二叉树，找出其最大深度。
 *  二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 *  说明: 叶子节点是指没有子节点的节点。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-01
 */


class MaximumDepth: StringSpec({

    "Maximum Depth" {
        TreeNode(3)
                .left(9)
                .right(TreeNode(20, 15, 7))
                .maxDepth() shouldBe 3
    }

    "Maximum Depth Loop" {
        TreeNode(3)
                .left(9)
                .right(TreeNode(20, 15, 7))
                .maxDepthLoop() shouldBe 3
    }
})

/**
 * DFS:
 *   时间复杂度: O(n), n为节点的个数
 *   空间复杂度:
 *     最坏的情况, 比如只有左树, 那么为 O(n)
 *     最好的情况, 树完全平衡, 那么为 O(log(n))
 */
private fun TreeNode?.maxDepth(): Int {
    this ?: return 0
    return 1 + max(
            this.left.maxDepth(),
            this.right.maxDepth()
    )
}

/**
 * BFS
 */
private fun TreeNode?.maxDepthLoop(): Int {
    this ?: return 0

    val queue = LinkedList<Pair<TreeNode?, Int>>()
    queue.add(this to 1)

    var depth = 0
    while (!queue.isEmpty()) {
        val (node, nodeDepth) = queue.poll()
        if (node != null) {
            depth = max(depth, nodeDepth)
            queue.add(node.left to nodeDepth + 1)
            queue.add(node.right to nodeDepth + 1)
        }
    }
    return depth
}