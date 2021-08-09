package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode
import java.util.*

/**
 * Desc:
 *
 * # 230. Kth Smallest Element in a BST (二叉搜索树中第K小的元素)
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 *
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-10
 */
class KthSmallestElementInBST : StringSpec({


    "Kth Smallest Element in a BST" {
        TreeNode(3)
                .left(TreeNode(1, null, 2))
                .right(4)
                .kthSmallest(1) shouldBe 1

        TreeNode(5)
                .left(TreeNode(3)
                        .left(TreeNode(2, 1, null))
                        .right(4)
                )
                .right(6)
                .kthSmallest(3) shouldBe 3
    }

    "Kth Smallest Element in a BST Loop" {
        TreeNode(3)
                .left(TreeNode(1, null, 2))
                .right(4)
                .kthSmallestLoop(1) shouldBe 1

        TreeNode(5)
                .left(TreeNode(3)
                        .left(TreeNode(2, 1, null))
                        .right(4)
                )
                .right(6)
                .kthSmallestLoop(3) shouldBe 3
    }

})

// 中序遍历
/**
 * 时间复杂度: O(N), 遍历了整个树。
 * 空间复杂度: O(N), 用了一个数组存储中序序列。
 */
private fun TreeNode?.kthSmallest(k: Int): Int {
    val temp = this.kthSmallest(k, mutableListOf())
    return temp[k - 1]
}

private fun TreeNode?.kthSmallest(k: Int, temp: MutableList<Int>): List<Int> {
    this ?: return temp
    this.left.kthSmallest(k - 1, temp)
    temp.add(this.`val`)
    this.right.kthSmallest(k - 1, temp)

    return temp
}

/**
 * 迭代中序遍历
 *
 * 时间复杂度: O(H+k)，其中 H 指的是树的高度，由于我们开始遍历之前，要先向下达到叶，
 *   当树是一个平衡树时：复杂度为 O(logN+k)。
 *   当树是一个不平衡树时：复杂度为 O(N+k)，此时所有的节点都在左子树。
 * 空间复杂度: O(H+k)。当树是一个平衡树时：O(logN+k)。当树是一个非平衡树时：O(N+k)。
 */
private fun TreeNode?.kthSmallestLoop(k: Int): Int {
    val queue = ArrayDeque<TreeNode>()

    var root = this
    var cnt = k
    while(true) {
        while (root != null) {
            queue.add(root)
            root = root.left
        }
        // 处理, 中断
        root = queue.removeLast()
        if (--cnt == 0) return root.`val`

        root = root?.right
    }
}
