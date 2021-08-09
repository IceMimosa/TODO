package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * # 98. Validate Binary Search Tree (验证二叉搜索树)
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * * 节点的左子树只包含小于当前节点的数。
 * * 节点的右子树只包含大于当前节点的数。
 * * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-14
 */

class ValidateBinarySearchTree : StringSpec({


    "Validate Binary Search Tree" {
        TreeNode(2, 1, 3).isValidBST(null, null) shouldBe true
        TreeNode(5, 1, null)
                .right(TreeNode(4, 3, 6))
                .isValidBST(null, null) shouldBe false
    }

})

/**
 * 递归, 设置左右上限
 */
private fun TreeNode?.isValidBST(lower: Int?, upper: Int?): Boolean {
    this ?: return true

    if (lower != null && this.`val` <= lower) return false
    if (upper != null && this.`val` >= upper) return false

    return this.left.isValidBST(lower, this.`val`)
            && this.right.isValidBST(this.`val`, upper)
}

/**
 * 中序遍历, 一遍搞定
 */
