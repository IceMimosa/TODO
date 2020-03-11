package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * TODO: DFS: 以根节点转换为求左右子树的最大深度 (错误)
 *
 * # 543. Diameter of Binary Tree (二叉树的直径)
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-10
 */
class DiameterOfBinaryTree : StringSpec({

    "Diameter of Binary Tree" {
        TreeNode(1)
                .left(TreeNode(2, 4, 5))
                .right(3)
                .diameterOfBinaryTree() shouldBe 3
    }

})

/**
 * DFS: 转换为求左右子树的最大深度
 *
 * 坑点: 不能以root为基准
 */
private fun TreeNode?.diameterOfBinaryTree(): Int {
    this ?: return 0

    var max = 0
    fun TreeNode?.deep(): Int {
        this ?: return 0
        val left = this.left.deep()
        val right = this.right.deep()
        max = Math.max(left + right, max)
        return Math.max(left, right) + 1
    }
    this.deep()
    return max
}
