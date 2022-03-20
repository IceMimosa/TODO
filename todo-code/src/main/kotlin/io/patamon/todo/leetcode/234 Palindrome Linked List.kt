package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.ListNode

/**
 *
 * 234. Palindrome Linked List（回文链表）
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * * 示例1
 *
 * ```
 * 输入：head = [1,2,2,1]
 * 输出：true
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：head = [1,2]
 * 输出：false
 * ```
 *
 * * 提示：
 * 1. 链表中节点数目在范围[1, 105] 内
 * 2. 0 <= Node.val <= 9
 *
 */
class PalindromeLinkedList : BaseSpec({

    "Palindrome Linked List" {
        ListNode.makeNodes(1, 2, 2, 1).isPalindrome() shouldBe true
        ListNode.makeNodes(1, 2, 1).isPalindrome() shouldBe true
    }
})

private fun ListNode?.isPalindrome(): Boolean {
    if (this == null || this.next == null) return true
    var slow = this
    var fast = this

    var pre: ListNode? = null
    while (fast != null && fast.next != null) {
        fast = fast.next!!.next

        val tmp = slow!!.next
        slow.next = pre
        pre = slow
        slow = tmp
    }
    // 奇数
    if (fast != null) {
        slow = slow!!.next
    }
    while (pre != null && slow != null) {
        if (pre.`val` != slow.`val`) {
            return false
        }
        pre = pre.next
        slow = slow.next
    }
    return true
}

