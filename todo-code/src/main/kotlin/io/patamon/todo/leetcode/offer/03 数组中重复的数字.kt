package io.patamon.todo.leetcode.offer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *
 *  找出数组中重复的数字。
 *
 *  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 *  请找出数组中任意一个重复的数字。
 *
 *  示例 1：
 *  输入：[2, 3, 1, 0, 2, 5, 3]
 *  输出：2 或 3
 *
 *  限制：2 <= n <= 100000
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-04-01
 */
class _03 : StringSpec({


    "03 数组中重复的数字" {
        intArrayOf(2, 3, 1, 0, 2, 5, 3).findRepeatNumberLoop() shouldBe 2
        intArrayOf(2, 3, 1, 0, 2, 5, 3).findRepeatNumberSet() shouldBe 2
        intArrayOf(2, 3, 1, 0, 2, 5, 3).findRepeatNumber() shouldBe 2
    }


})


/**
 * 循环解决
 *   时间: O(n^2)
 *   空间: O(1)
 *
 * 或者先排序, 时间复杂度更低些
 */
private fun IntArray?.findRepeatNumberLoop(): Int {
    if (this == null || this.isEmpty()) return -1

    for (i in (0 until this.size)) {
        for (j in (i + 1 until this.size)) {
            if (this[i] == this[j]) {
                return this[i]
            }
        }
    }
    return -1
}

/**
 * 使用 Set
 *   时间: O(n)
 *   空间: O(n)
 */
private fun IntArray?.findRepeatNumberSet(): Int {
    if (this == null || this.isEmpty()) return -1

    val set = mutableSetOf<Int>()
    for (i in (0 until this.size)) {
        if (set.contains(this[i])) {
            return this[i]
        }
        set.add(this[i])
    }
    return -1
}

/**
 * 根据题意, 数字范围是 0 ~ n-1, 按理说如果不存在, 刚好填满。使用下标定位
 * 时间: O(n)
 * 空间: O(1)
 *
 * 会破坏原有结构
 */
private fun IntArray?.findRepeatNumber(): Int {
    if (this == null || this.isEmpty()) return -1

    var temp: Int
    for (i in (0 until this.size)) {
        while (this[i] != i) {
            if (this[i] == this[this[i]]) {
                return this[i]
            }
            temp = this[i]
            this[i] = this[temp]
            this[temp] = temp
        }
    }
    return -1
}
