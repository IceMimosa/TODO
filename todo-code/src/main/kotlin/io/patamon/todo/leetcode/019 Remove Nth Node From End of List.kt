package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.ListNode

/**
 * 019. Remove Nth Node From End of List （删除链表的倒数第 N 个结点）
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * * 示例1
 *
 * https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg
 *
 * ```
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：head = [1], n = 1
 * 输出：[]
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * ```
 *
 * 提示：
 *
 * * 链表中结点的数目为 sz
 * * 1 <= sz <= 30
 * * 0 <= Node.val <= 100
 * * 1 <= n <= sz
 */
class RemoveNthNodeFromEndOfList : BaseSpec({

    "Remove Nth Node From End of List" {
        ListNode.makeNodes(1, 2).removeNthFromEnd(1)?.getAllValues() shouldBe listOf(1)
        ListNode.makeNodes(1, 2).removeNthFromEnd(2)?.getAllValues() shouldBe listOf(2)
        ListNode.makeNodes(1, 2, 3, 4, 5).removeNthFromEnd(2)?.getAllValues() shouldBe listOf(1, 2, 3, 5)
        (ListNode.makeNodes(1).removeNthFromEnd(1)?.getAllValues() ?: emptyList()) shouldBe listOf()
    }
})

private fun ListNode?.removeNthFromEnd(n: Int): ListNode? {
    if (this == null || this.next == null) return null

    val pre = ListNode(-1).also {
        it.next = this
    }
    var p: ListNode? = pre
    var q: ListNode? = pre
    for (i in 1..n) {
        q = q?.next
    }

    while (q?.next != null) {
        q = q.next
        p = p?.next
    }

    if (p != null) p.next = p.next?.next
    return pre.next
}
