package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *
 * 002. Add Two Numbers (两数相加)
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例:
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-29
 */
class AddTwoNumbers : StringSpec({

    "Add Two Numbers" {
        ListNode.makeNodes(2, 4, 3)
                .addTwoNumbers(ListNode.makeNodes(5, 6, 4))
                ?.getAllValues() shouldBe listOf(7, 0, 8)
        ListNode.makeNodes(5)
                .addTwoNumbers(ListNode.makeNodes(5))
                ?.getAllValues() shouldBe listOf(0, 1)
    }


})

private fun ListNode?.addTwoNumbers(l: ListNode?): ListNode? {
    if (this == null) return l
    if (l == null) return this

    val result = ListNode(-1)
    var r = result

    // 双指针遍历
    var l1: ListNode? = this
    var l2: ListNode? = l

    // 进位记录
    var cnt = 0
    while (l1 != null || l2 != null) {
        val v = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + cnt
        cnt = v / 10
        r.next = ListNode(v % 10)
        r = r.next!!

        l1 = l1?.next
        l2 = l2?.next
    }

    // 注意 cnt 不为 0
    if (cnt != 0) {
        r.next = ListNode(cnt)
    }

    return result.next
}

