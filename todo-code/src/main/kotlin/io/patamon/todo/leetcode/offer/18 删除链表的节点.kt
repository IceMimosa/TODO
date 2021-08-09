package io.patamon.todo.leetcode.offer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 说明：
 *   题目保证链表中节点的值互不相同
 *   若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020/7/26
 */
class _18 : StringSpec({

    "18 删除链表的节点" {
        // 双指针解法
        // 也可以用单指针
        fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
            head ?: return head
            if (head.`val` == `val`) {
                return head.next
            }

            var pre = head
            var curr = pre?.next
            while (curr != null) {
                if (curr!!.`val` == `val`) {
                    pre?.next = curr?.next
                    break
                }
                pre = curr
                curr = pre?.next
            }
            return head
        }

        deleteNode(ListNode.makeNodes(4, 5, 1, 9), 5)?.getAllValues() shouldBe arrayListOf(4, 1, 9)
    }

})
