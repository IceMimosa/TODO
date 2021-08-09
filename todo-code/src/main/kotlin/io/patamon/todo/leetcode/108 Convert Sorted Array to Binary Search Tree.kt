package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *  108. Convert Sorted Array to Binary Search Tree (将有序数组转换为二叉搜索树)
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-04-20
 */
class ConvertSortedArrayToBinarySearchTree : StringSpec({

    "Convert Sorted Array to Binary Search Tree" {
        intArrayOf(-10, -3, 0, 5, 9).sortedArrayToBST()
    }

})

/**
 * 根据 中序遍历 数据去恢复一颗平衡二叉树, 那么折半恢复即可
 *
 * 其他根节点选择: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/
 */
private fun IntArray?.sortedArrayToBST(): TreeNode? {
    if (this == null || this.isEmpty()) return null

    val mid = this.size / 2
    val node = TreeNode(this[mid])

    // 左边到头
    if (mid > 0) {
        node.left = this.sliceArray(0 until mid).sortedArrayToBST()
    }

    // 右边到头
    if (mid < this.size - 1) {
        node.right = this.sliceArray(mid + 1 until this.size).sortedArrayToBST()
    }
    return node
}
