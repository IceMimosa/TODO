package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode
import java.util.*

/**
 * Desc:
 *
 * # 102. Binary Tree Level Order Traversal (二叉树的层次遍历)
 *
 *  给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-01
 */


class BinaryTreeLevelOrderTraversal : StringSpec({

    "Binary Tree Level Order Traversal" {
        TreeNode(3)
                .left(9)
                .right(TreeNode(20, 15, 7))
                .levelOrder() shouldBe listOf(listOf(3), listOf(9, 20), listOf(15, 7))

        TreeNode(3)
                .left(9)
                .right(TreeNode(20, 15, 7))
                .levelOrderDFS(mutableListOf()) shouldBe listOf(listOf(3), listOf(9, 20), listOf(15, 7))
    }

})

/**
 * BFS: 使用队列进行广度优先遍历
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
private fun TreeNode?.levelOrder(): List<List<Int>> {
    val nodes = mutableListOf<MutableList<Int>>()
    this ?: return nodes

    val queue = ArrayDeque<Pair<Int, TreeNode?>>()
    queue.offer(0 to this)
    while(queue.isNotEmpty()) {
        val (index, node) = queue.poll()
        if (node != null) {
            if (nodes.size <= index) {
                nodes.add(mutableListOf())
            }
            nodes[index].add(node.`val`)

            // 入队列
            queue.offer(index + 1 to node.left)
            queue.offer(index + 1 to node.right)
        }
    }
    return nodes
}

/**
 * DFS: 使用深度优先遍历
 */
private fun TreeNode?.levelOrderDFS(nodes: MutableList<MutableList<Int>>, level: Int = 0): List<List<Int>> {
    this ?: return nodes

    if (nodes.size <= level) {
        nodes.add(mutableListOf())
    }
    nodes[level].add(this.`val`)

    this.left.levelOrderDFS(nodes, level + 1)
    this.right.levelOrderDFS(nodes, level + 1)

    return nodes
}
