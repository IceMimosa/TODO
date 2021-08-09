package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * ```
 * Input: 1->1->2
 * Output: 1->2
 * ```
 *
 * Example 2:
 *
 * ```
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * ```
 *
 * =============================================================================================================
 *
 * # 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/9/5
 */
class RemoveDuplicatesFromSortedList : StringSpec({


    /**
     * [removeDuplicates]
     */
    "直接法" {
        ListNode.makeNodes(1, 1, 2).removeDuplicates()?.getAllValues() shouldBe mutableListOf(1, 2)
        ListNode.makeNodes(1, 1, 2, 3, 3).removeDuplicates()?.getAllValues() shouldBe mutableListOf(1, 2, 3)
    }

    /**
     * [recursiveDelete]
     */
    "递归法" {
        ListNode.makeNodes(1, 1, 2).recursiveDelete()?.getAllValues() shouldBe mutableListOf(1, 2)
        ListNode.makeNodes(1, 1, 2, 3, 3).recursiveDelete()?.getAllValues() shouldBe mutableListOf(1, 2, 3)
    }
})

/**
 * 直接法: 找到重复的节点直接替换next节点
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
private fun ListNode?.removeDuplicates(): ListNode? {
    // null 和 一个节点的情况
    if (this == null || this.next == null) return this

    var curr: ListNode? = this
    // 如果下一个节点不是 null
    while (curr?.next != null) {
        // 值相等
        if (curr.`val` == curr.next!!.`val`) {
            curr.next = curr.next!!.next
        }
        // 值不相等
        else {
            curr = curr.next
        }
    }
    return this
}

/**
 * 递归法, 但是在元素过多会有 StackOverflowError
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
private fun ListNode?.recursiveDelete(): ListNode? {
    if (this == null || this.next == null) return this
    this.next = this.next.recursiveDelete()
    return if (this.`val` == this.next!!.`val`) this.next else this
}

