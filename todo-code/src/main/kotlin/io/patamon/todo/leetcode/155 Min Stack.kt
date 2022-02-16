package io.patamon.todo.leetcode

import io.patamon.todo.common.BaseSpec

/**
 * 155.Min Stack (最小栈)
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * * push(x) —— 将元素 x 推入栈中。
 * * pop() —— 删除栈顶的元素。
 * * top() —— 获取栈顶元素。
 * * getMin() —— 检索栈中的最小元素。
 *
 * 提示：pop、top 和 getMin 操作总是在 `非空栈` 上调用。
 *
 */
class MinStack : BaseSpec({

    "Min Stack" {
        val minStack = MyMinStack()
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        println(minStack.getMin() )  // 返回 -3.
        minStack.pop()
        println(minStack.top())      // 返回 0.
        println(minStack.getMin())   // 返回 -2.
    }
})


/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
private class MyMinStack {
    private val stack = java.util.ArrayDeque<Int>()
    private val min = java.util.ArrayDeque<Int>()

    /** initialize your data structure here. */
    fun push(v: Int) {
        stack.push(v)

        val n = min.peek()
        if (n == null || n >= v) {
            min.push(v)
        }
    }

    fun pop() {
        val v = stack.pop()
        val n = min.peek()
        if (n != null && n == v) {
            min.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return min.peek()
    }
}
