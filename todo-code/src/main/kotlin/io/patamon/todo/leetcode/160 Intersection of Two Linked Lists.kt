package io.patamon.todo.leetcode

import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.ListNode

/**
 * Desc:
 *   160. Intersection of Two Linked Lists (相交链表)
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2021/8/11
 */
class `160 Intersection of Two Linked Lists` : BaseSpec({


    "Intersection of Two Linked Lists" {

    }
})

// 1. 与 141 类似, 使用set

// 2. m+n = n+m

private fun ListNode?.getIntersectionNode(node: ListNode?): ListNode? {
    if (this == null || node == null) return null
    var a = this
    var b = node
    while (a != b) {
        a = if (a == null) node else a.next
        b = if (b == null) this else b.next
    }
    return a
}
