package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.ListNode

/**
 * 23. Merge k Sorted Lists（合并K个升序链表）
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * * 示例1
 *
 * ```
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：lists = [] 或者 lists = [[]]
 * 输出：[]
 * ```
 */
class MergeKSortedLists : BaseSpec({

    "Merge k Sorted Lists" {
        arrayOf(
            ListNode.makeNodes(1, 4, 5),
            ListNode.makeNodes(1, 3, 4),
            ListNode.makeNodes(2, 6),
        ).mergeKLists()?.getAllValues() shouldBe listOf(1, 1, 2, 3, 4, 4, 5, 6)
    }
})

private fun Array<ListNode?>.mergeKLists(): ListNode? {
    if (this.isEmpty()) return null
    return this.reduce { l1, l2 -> l1.merge(l2) }
}

private fun ListNode?.merge(l: ListNode?): ListNode? {
    if (this == null) return l
    if (l == null) return this

    val head = ListNode(-1)
    var next = head

    var n1 = this
    var n2 = l
    while (n1 != null && n2 != null) {
        if (n1.`val` <= n2.`val`) {
            next.next = n1
            n1 = n1.next
        } else {
            next.next = n2
            n2 = n2.next
        }
        next = next.next!!
    }
    next.next = n1 ?: n2
    return head.next
}

