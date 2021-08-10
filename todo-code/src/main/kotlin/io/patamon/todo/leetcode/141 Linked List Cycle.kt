package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *   141. Linked List Cycle (环形链表)
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2021/8/10
 */
class `141 Linked List Cycle` : BaseSpec({

    "Linked List Cycle" {
        // 3 -> 2 -> 0 -> -4
        //      ^---------┘
        val l1 = ListNode(-4)
        val l2 = ListNode.makeNodes(ListNode(3), ListNode(2), ListNode(0), l1)!!
        l1.next = l2.next
        l2.cycleWithSet() shouldBe true
        l2.cycleWith2Point() shouldBe true
    }

})

/**
 * set临时存储
 *
 * 时间复杂度: O(N)
 * 空间复杂度: O(N)
 */
private fun ListNode?.cycleWithSet(): Boolean {
    if (this == null || this.next == null) return false

    var curr = this.next!!.next
    val set = hashSetOf<ListNode>()
    while (curr != null) {
        if (!set.add(curr)) {
            return true
        }
        curr = curr.next!!
    }
    return false
}

/**
 * 快慢指针
 *
 * 时间复杂度: O(N)
 * 空间复杂度: O(1)
 */
private fun ListNode?.cycleWith2Point(): Boolean {
    if (this == null || this.next == null) return false

    var slow = this
    var fast = this.next
    while (slow != fast) {
        if (fast?.next == null) {
            return false
        }
        slow = slow?.next
        fast = fast.next?.next
    }
    return true
}
