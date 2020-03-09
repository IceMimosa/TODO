package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.TreeNode

/**
 * Desc:
 *
 * # 671. Second Minimum Node In a Binary Tree (二叉树中第二小的节点)
 *
 *  给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 *  如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 *
 *  给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-01
 */


class SecondMinimumNode: StringSpec({

    "Second Minimum Node In a Binary Tree" {
        TreeNode(2)
                .left(2)
                .right(TreeNode(5, 5, 7))
                .findSecondMinimumValue() shouldBe 5
        TreeNode(2, 2, 2).findSecondMinimumValue() shouldBe -1
    }
})

private fun TreeNode?.findSecondMinimumValue(): Int {
    this ?: return -1

    if (this.left == null && this.right == null) {
        return -1
    }

    // 左子树只有相等的时候才需要继续变量
    var left = this.left!!.`val`
    if (left == this.`val`) {
        left = this.left.findSecondMinimumValue()
    }

    // 同理右子树
    var right = this.right!!.`val`
    if (right == this.`val`) {
        right = this.right.findSecondMinimumValue()
    }

    return when {
        left != -1 && right != -1 -> Math.min(left, right)
        left != -1 -> left
        else -> right
    }
}