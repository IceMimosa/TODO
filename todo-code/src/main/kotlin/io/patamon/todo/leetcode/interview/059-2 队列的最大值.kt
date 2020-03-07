package io.patamon.todo.leetcode.interview

import java.util.*

/**
 * Desc:
 *
 *   面试题59 - II. 队列的最大值
 *
 *   请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *   若队列为空，pop_front 和 max_value 需要返回 -1
 *
 *   示例1
 *   输入:
 *    ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 *    [[],[1],[2],[],[],[]]
 *   输出: [null,null,null,2,1,2]
 *
 *   示例2
 *   输入:
 *    ["MaxQueue","pop_front","max_value"]
 *    [[],[],[]]
 *   输出: [null,-1,-1]
 *
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-07
 */

// 解答: https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/

class MaxQueue {

    private val queue = ArrayDeque<Int>()
    // 辅助队列
    private val help = ArrayDeque<Int>()

    fun max_value(): Int {
        return if (queue.isEmpty()) -1 else help.peek()
    }

    fun push_back(value: Int) {
        while (!help.isEmpty() && help.peekLast() < value) {
            help.pollLast()
        }
        queue.offer(value)
        help.offer(value)
    }

    fun pop_front(): Int {
        if (queue.isEmpty()) return -1

        val v = queue.pop()
        if (help.peek() == v) {
            help.pop()
        }
        return v
    }
}