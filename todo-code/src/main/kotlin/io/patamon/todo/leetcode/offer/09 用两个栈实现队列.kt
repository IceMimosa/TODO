package io.patamon.todo.leetcode.offer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.util.ArrayDeque


/**
 * Desc:
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020/7/26
 */
class _09 : StringSpec({

    "09 用两个栈实现队列" {
        val queue = CQueue()
        queue.deleteHead() shouldBe -1
        queue.appendTail(5)
        queue.appendTail(2)
        queue.deleteHead() shouldBe 5
        queue.deleteHead() shouldBe 2
    }
})

private class CQueue {

    private val stack1 = ArrayDeque<Int>()
    private val stack2 = ArrayDeque<Int>()

    fun appendTail(value: Int) {
        stack1.push(value)
    }

    fun deleteHead(): Int {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1
        }
        if (!stack2.isEmpty()) {
            return stack2.pop()
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop())
        }
        return stack2.pop()
    }
}
