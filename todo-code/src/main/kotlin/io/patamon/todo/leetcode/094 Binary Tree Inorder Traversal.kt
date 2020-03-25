package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode
import java.util.*

/**
 * Desc:
 *
 *  # 94. Binary Tree Inorder Traversal (二叉树的中序遍历)
 *
 *  进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-12
 */
class BinaryTreeInorderTraversal : StringSpec({


    "Binary Tree Inorder Traversal" {
        TreeNode(1, null)
                .right(TreeNode(2, 3, null))
                .inorderTraversal(mutableListOf()) shouldBe listOf(1, 3, 2)
    }

    "Binary Tree Inorder Traversal Loop" {
        TreeNode(1, null)
                .right(TreeNode(2, 3, null))
                .inorderTraversalLoop(mutableListOf()) shouldBe listOf(1, 3, 2)
    }

    "Binary Tree Inorder Traversal Morris" {
        TreeNode(1, null)
                .right(TreeNode(2, 3, null))
                .inorderTraversalMorris(mutableListOf()) shouldBe listOf(1, 3, 2)
    }

    "Binary Tree Inorder Traversal Color" {
        TreeNode(1, null)
                .right(TreeNode(2, 3, null))
                .inorderTraversalColorMark(mutableListOf()) shouldBe listOf(1, 3, 2)
    }


})

/**
 * DFS: 中序遍历, 递归
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(h), h为树的高度
 */
private fun TreeNode?.inorderTraversal(nodes: MutableList<Int>): List<Int> {
    this ?: return nodes
    this.left.inorderTraversal(nodes)
    nodes.add(this.`val`)
    this.right.inorderTraversal(nodes)
    return nodes
}


/**
 * 使用辅助栈实现迭代的方式
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(h), h为树的高度
 */
private fun TreeNode?.inorderTraversalLoop(nodes: MutableList<Int>): List<Int> {
    this ?: return nodes

    val stack = ArrayDeque<TreeNode>()
    var n = this
    while (stack.isNotEmpty() || n != null) {
        // 将所有左子树全部入栈
        while (n != null) {
            stack.push(n)
            n = n.left
        }

        // 处理
        n = stack.pop()
        nodes.add(n.`val`)

        // 处理右子树
        n = n.right
    }
    return nodes
}

/**
 * 莫里斯遍历
 *
 * 好处是不需要辅助空间, 坏处是破坏了原来的树结构
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
private fun TreeNode?.inorderTraversalMorris(nodes: MutableList<Int>): List<Int> {
    this ?: return nodes

    var n: TreeNode? = this
    var pre: TreeNode
    while (n != null) {
        if (n.left != null) {
            pre = n.left!!
            // 找到左节点的最右节点
            while (pre.right != null) {
                pre = pre.right!!
            }
            // 将n赋给pre的right节点
            pre.right = n

            // 继续遍历下一个左节点
            val temp = n
            n = n.left
            temp.left = null // 注意清掉上个n左节点, 以免死循环
        } else {
            nodes.add(n.`val`)
            n = n.right
        }
    }

    return nodes
}


/**
 * 颜色标记法, 能统一遍历的写法
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 */
private fun TreeNode?.inorderTraversalColorMark(nodes: MutableList<Int>): List<Int> {
    this ?: return nodes

    // 白色: 未访问, 灰色: 访问
    val WHITE = 0
    val GRAY = 1

    val stack = ArrayDeque<Pair<TreeNode?, Int>>()
    stack.push(this to WHITE)
    while (stack.isNotEmpty()) {
        val (node, color) = stack.pop()
        if (node == null) continue
        when (color) {
            WHITE -> {
                // 入栈顺序
                // 中序遍历: 右中左
                // 先序遍历: 右左中
                // 后序遍历: 中右左
                stack.push(node.right to WHITE)
                stack.push(node to GRAY)
                stack.push(node.left to WHITE)
            }
            GRAY -> {
                nodes.add(node.`val`)
            }
        }
    }
    return nodes
}
