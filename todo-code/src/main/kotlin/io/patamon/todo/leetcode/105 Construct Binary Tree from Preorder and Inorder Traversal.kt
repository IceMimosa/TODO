package io.patamon.todo.leetcode

import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal (从前序与中序遍历序列构造二叉树)
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 *   你可以假设树中没有重复的元素。
 *
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-26
 */

class ConstructBinaryTreeFromPreorderAndInorderTraversal : StringSpec({

    "Construct Binary Tree from Preorder and Inorder Traversal" {
        buildTree0(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
    }

})

private fun buildTree0(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) {
        return null
    }

    // 确定 root 节点
    val tree = TreeNode(preorder[0])

    // 定位中序遍历中 root 节点的位置值
    val rootValIndex = inorder.indexOf(tree.`val`)

    // 构建左子树, 0 表左边到头了
    if (rootValIndex != 0) {
        tree.left = buildTree0(
                preorder.sliceArray(1 until rootValIndex - 0 + 1),
                inorder.sliceArray(0 until rootValIndex)
        )
    }

    // 构建又子树, inorder.size - 1 表示右边到头了树
    if (rootValIndex != inorder.size - 1) {
        tree.right = buildTree0(
                preorder.sliceArray(rootValIndex - 0 + 1 until preorder.size),
                inorder.sliceArray(rootValIndex + 1 until inorder.size)
        )
    }

    return tree
}
