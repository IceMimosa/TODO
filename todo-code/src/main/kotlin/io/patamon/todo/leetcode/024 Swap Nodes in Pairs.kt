package io.patamon.todo.leetcode

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.ListNode

/**
 * 024. Swap Nodes in Pairs（两两交换链表中的节点）
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * * 示例1
 *
 * ```
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：head = []
 * 输出：[]
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：head = [1]
 * 输出：[1]
 * ```
 *
 * 提示：
 *
 * * 链表中节点的数目在范围 [0, 100] 内
 * * 0 <= Node.val <= 100
 */
class SwapNodesInPairs : BaseSpec({

    "Container With Most Water" {
        ListNode.makeNodes(1).swapPairs()?.getAllValues() shouldBe listOf(1)
        ListNode.makeNodes(1, 2, 3, 4).swapPairs()?.getAllValues() shouldBe listOf(2, 1, 4, 3)
        ListNode.makeNodes(1, 2, 3).swapPairs()?.getAllValues() shouldBe listOf(2, 1, 3)
    }
})


private fun ListNode?.swapPairs(): ListNode? {
    if (this == null || this.next == null) return this
    val head = this.next

    var pre: ListNode? = null
    var slow: ListNode? = this
    var fast: ListNode? = this.next?.next
    while (slow?.next != null) {
        val tmp = slow.next!!
        slow.next = fast
        tmp.next = slow
        if (pre != null) {
            pre.next = tmp
        }

        pre = slow
        slow = fast
        fast = fast?.next?.next
    }
    return head
}

