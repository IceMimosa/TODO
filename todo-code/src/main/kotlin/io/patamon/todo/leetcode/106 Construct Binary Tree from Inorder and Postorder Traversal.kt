package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * 105. Construct Binary Tree from Inorder and Postorder Traversal (从中序与后序遍历序列构造二叉树)
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 *   你可以假设树中没有重复的元素。
 *
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-26
 */

class ConstructBinaryTreeFromInorderAndPostorderTraversal : StringSpec({

    "Construct Binary Tree from Inorder and Postorder Traversal" {
        buildTree0(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3))
    }

})

private fun buildTree0(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (postorder.isEmpty()) {
        return null
    }

    // 确定 root 节点
    val tree = TreeNode(postorder.last())

    // 定位中序遍历中 root 节点的位置值
    val rootValIndex = inorder.indexOf(tree.`val`)

    // 构建左子树, 0 表左边到头了
    if (rootValIndex != 0) {
        tree.left = buildTree0(
                inorder.sliceArray(0 until rootValIndex),
                postorder.sliceArray(0 until rootValIndex)
        )
    }

    // 构建右子树, inorder.size - 1 表示右边到头了树
    if (rootValIndex != inorder.size - 1) {
        tree.right = buildTree0(
                inorder.sliceArray(rootValIndex + 1 until inorder.size),
                postorder.sliceArray(rootValIndex until postorder.size - 1)
        )
    }

    return tree
}
