package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode
import java.util.*

/**
 * Desc: TODO
 *
 * # 99. Recover Binary Search Tree (恢复二叉搜索树)
 *
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 进阶:
 * * 使用 O(n) 空间复杂度的解法很容易实现。
 * * 你能想出一个只使用常数空间的解决方案吗？
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-14
 */

class RecoverBinarySearchTree : StringSpec({


    "Recover Binary Search Tree" {
        val tree = TreeNode(1).left(TreeNode(3, null, 2))
        tree.inorder(mutableListOf())
        tree.`val` shouldBe 3
    }

})

/**
 * 中序遍历 + 中间的集合遍历
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
private fun TreeNode?.inorder(nodes: MutableList<TreeNode>): List<TreeNode> {
    this ?: return nodes

    val WHITE = 0
    val GRAY  = 1
    val stack = ArrayDeque<Pair<TreeNode?, Int>>()
    stack.push(this to WHITE)

    while (stack.isNotEmpty()) {
        val (node, color) = stack.pop()
        if (node == null) continue
        when (color) {
            WHITE -> {
                stack.push(node.right to WHITE)
                stack.push(node to GRAY)
                stack.push(node.left to WHITE)
            }
            GRAY -> {
                var i = 0
                while (i < nodes.size) {
                    if (nodes[i].`val` > node.`val`) {
                        val temp = node.`val`
                        node.`val` = nodes[i].`val`
                        nodes[i].`val` = temp
                    }
                    i++
                }
                nodes.add(node)
            }
        }
    }
    return nodes
}
