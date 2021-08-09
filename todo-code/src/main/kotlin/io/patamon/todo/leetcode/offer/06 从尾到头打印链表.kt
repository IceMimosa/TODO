package io.patamon.todo.leetcode.offer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *
 *  从尾到头打印链表
 *
 *  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-04-01
 */
class _06 : StringSpec({


    "06 从尾到头打印链表" {
        ListNode.makeNodes(1, 3, 2).reversePrint(mutableListOf()) shouldBe arrayOf(2, 3, 1)
        ListNode.makeNodes(1, 3, 2).reversePrintRecursion(mutableListOf()) shouldBe arrayOf(2, 3, 1)
    }

})


/**
 * 辅助list
 */
private fun ListNode?.reversePrint(nodes: MutableList<Int>): IntArray {
    this ?: return intArrayOf()

    var n = this
    while (n != null) {
        nodes.add(n.`val`)
        n = n.next
    }
    return nodes.asReversed().toIntArray()
}

/**
 * 递归
 */
private fun ListNode?.reversePrintRecursion(nodes: MutableList<Int>): IntArray {
    this ?: return intArrayOf()

    this.next.reversePrintRecursion(nodes)
    nodes.add(this.`val`)

    return nodes.toIntArray()
}
