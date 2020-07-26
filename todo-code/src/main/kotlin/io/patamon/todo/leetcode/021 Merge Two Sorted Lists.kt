package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
 * together the nodes of the first two lists.
 *
 * Example:
 *
 * ```
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * ```
 *
 * =============================================================================================================
 *
 * # 21. 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例:
 *
 * ```
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * ```
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 *
 * // 节点类, [ListNode]
 * class ListNode(var `val`: Int = 0) {
 *   var next: ListNode? = null
 *
 *   ......
 * }
 */
class MergeTwoSortedLists : StringSpec({

    /**
     * [merge]
     */
    "merge two sorted lists" {
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
    while (l1 != null) {
        curr.next = l1
        l1 = l1.next
        curr = curr.next!!
    }

    // 如果 l2 还有剩余节点
    while (l2 != null) {
        curr.next = l2
        l2 = l2.next
        curr = curr.next!!
    }
    // 最后一步可以直接赋值链表...
    // curr.next = l1 ?: l2

    // 返回output的下一个, 因为第一个不算
    return output.next
}
