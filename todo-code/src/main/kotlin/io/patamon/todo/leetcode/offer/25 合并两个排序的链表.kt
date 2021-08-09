package io.patamon.todo.leetcode.offer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *
 * [io.patamon.todo.leetcode.MergeTwoSortedLists]
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020/7/26
 */

class _25 : StringSpec({

    "25. 合并两个排序的链表" {
        ListNode.makeNodes(1, 2, 4).merge(ListNode.makeNodes(1, 3, 4))?.getAllValues() shouldBe mutableListOf(1, 1, 2, 3, 4, 4)
        ListNode.makeNodes(1, 2, 4, 5, 6).merge(ListNode.makeNodes(1, 3, 4))?.getAllValues() shouldBe mutableListOf(1, 1, 2, 3, 4, 4, 5, 6)
    }
})

/**
 * 合并两个有序的链表, 类似归并排序
 *
 * 时间复杂度: O(n), n表示两个链表的长度
 * 空间复杂度: O(1), 纯引用指向, 没有开辟额外的空间
 */
private fun ListNode?.merge(node: ListNode?): ListNode? {
    this ?: return node
    node ?: return this

    val output = ListNode(0)
    // 记录两个节点
    var l1 = this
    var l2 = node

    // 记录输出的当前节点
    var curr = output
    while (l1 != null && l2 != null) {
        // 如果l1的值小, curr.next 指向l1
        if (l1.`val` <= l2.`val`) {
            curr.next = l1
            l1 = l1.next
        }
        // 否则指向l2
        else {
            curr.next = l2
            l2 = l2.next
        }
        // curr 后移
        curr = curr.next!!
    }

    // 如果 l1 还有剩余节点
    curr.next = l1 ?: l2

    // 返回output的下一个, 因为第一个不算
    return output.next
}
