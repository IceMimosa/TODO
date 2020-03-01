package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode

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

})

/**
 * 递归解法: O(n)
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

