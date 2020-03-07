package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode
import java.util.*

/**
 * Desc:
 *
 * # 101. Symmetric Tree (对称二叉树)
 *
 *  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-01
 */


class SymmetricTree: StringSpec({


    "Symmetric Tree" {
        TreeNode(1)
                .left(TreeNode(2, 3, 4))
                .right(TreeNode(2, 4, 3))
                .isSymmetric() shouldBe true
        TreeNode(1)
                .left(TreeNode(2, null, 3))
                .right(TreeNode(2, null, 3))
                .isSymmetric() shouldBe false
    }

    "Symmetric Tree Loop" {
        TreeNode(1)
                .left(TreeNode(2, 3, 4))
                .right(TreeNode(2, 4, 3))
                .isSymmetricLoop() shouldBe true
        TreeNode(1)
                .left(TreeNode(2, null, 3))
                .right(TreeNode(2, null, 3))
                .isSymmetricLoop() shouldBe false
    }
})

/**
 * 递归解法
 *   时间复杂度: O(n)
 *   空间复杂度: O(n), 递归调用占用的栈内存分配
 */
private fun TreeNode?.isSymmetric(): Boolean {
    this ?: return true
    return isSymmetric(this.left, this.right)
}

private fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {

    if (left == null && right == null) return true
    if (left == null || right == null) return false
    if (left.`val` != right.`val`) return false

    return isSymmetric(left.left, right.right)
            && isSymmetric(left.right, right.left)
}

/**
 * 迭代解法
 *   时间复杂度: O(n)
 *   空间复杂度: O(n)
 */
private fun TreeNode?.isSymmetricLoop(): Boolean {
    this ?: return true
    val q = LinkedList<TreeNode?>()
    q.add(this)
    q.add(this)
    while (!q.isEmpty()) {
        val t1 = q.poll()
        val t2 = q.poll()
        if (t1 == null && t2 == null) continue
        if (t1 == null || t2 == null) return false
        if (t1.`val` != t2.`val`) return false
        q.add(t1.left)
        q.add(t2.right)
        q.add(t1.right)
        q.add(t2.left)
    }
    return true
}

