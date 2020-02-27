package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 100. Same Tree
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * ```
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * ```
 *
 * Example 2:
 *
 * ```
 *Input:     1         1
 *          /           \
 *         2             2
 *
 *        [1,2],     [1,null,2]
 *
 * Output: false
 *
 * ```
 *
 * Example 3:
 *
 * ```
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 * ```
 *
 * =============================================================================================================
 *
 * # 100. 相同的数
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/09/10
 */
class SameTree: StringSpec({

    "Same Tree" {
        TreeNode(1, 2, 3).isSameTree(TreeNode(1, 2, 3)) shouldBe true
        TreeNode(1, 2).isSameTree(TreeNode(1, null, 2)) shouldBe false
        TreeNode(1, 2, 1).isSameTree(TreeNode(1, 1, 2)) shouldBe false
    }

})

private fun TreeNode?.isSameTree(o: TreeNode?): Boolean {
    if (this == null && o == null) return true
    if (this == null || o == null) return false
    if (this.`val` != o.`val`) return false

    return this.left.isSameTree(o.left) && this.right.isSameTree(o.right)
}

