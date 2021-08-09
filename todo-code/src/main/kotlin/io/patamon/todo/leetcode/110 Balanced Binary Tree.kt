package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *  110. Balanced Binary Tree (平衡二叉树)
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode/
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-04-21
 */

class BalancedBinaryTree : StringSpec({


    "Balanced Binary Tree" {
        TreeNode(1, null)
                .right(TreeNode(2, null, 3))
                .isBalanced() shouldBe false
        TreeNode(3)
                .left(9)
                .right(TreeNode(20, 15, 7))
                .isBalanced() shouldBe true
        TreeNode(1)
                .right(2)
                .left(TreeNode(2).right(3).left(TreeNode(3, 4, 4)))
                .isBalanced() shouldBe false
    }

})

/**
 * 自顶向下递归, 只要有一个节点满足  |height(p.left) - height(p.right)| > 1 时, 它就是不平衡的
 *
 * 时间复杂度: O(nlogn)
 * 空间复杂度: O(n)
 */
private fun TreeNode?.isBalanced(): Boolean {
    this ?: return true

    val l = this.left.level()
    val r = this.right.level()

    return (Math.abs(l - r) <= 1) && this.left.isBalanced() && this.right.isBalanced()
}

// 获取树的高度
private fun TreeNode?.level(l: Int = 0): Int {
    this ?: return l
    return Math.max(this.left.level(l + 1), this.right.level(l + 1))
}

/**
 * 也可以使用 自底向上 的方式, 后序遍历的一种应用
 */
