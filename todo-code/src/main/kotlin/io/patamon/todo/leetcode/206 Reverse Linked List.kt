package io.patamon.todo.leetcode

import io.kotlintest.specs.StringSpec
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *   206. Reverse Linked List (反转链表)
 *
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020/7/26
 */
class ReverseLinkedList : StringSpec({

    "206. Reverse Linked List" {
        ListNode.makeNodes(1, 2, 3, 4, 5).reverseList()
        ListNode.makeNodes(1).reverseList()
    }
})

/**
 * 循环写法
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
private fun ListNode?.reverseList(): ListNode? {
    this ?: return this

    var pre: ListNode? = null
    var curr = this
    while (curr != null) {
        val tmp = curr.next
        curr.next = pre
        pre = curr
        curr = tmp
    }
    return pre
}

/**
 * 递归写法
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 * public ListNode reverseList(ListNode head) {
 *     if (head == null || head.next == null) return head;
 *     ListNode p = reverseList(head.next);
 *     head.next.next = head;
 *     head.next = null;
 *     return p;
 * }
 */