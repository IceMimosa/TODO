package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 283. Move Zeroes （移动零）
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * * 示例1
 *
 * ```
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入: nums = [0]
 * 输出: [0]
 * ```
 *

 * 提示：
 *
 * * 1 <= nums.length <= 104
 * * -231 <= nums[i] <= 231 - 1
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */
class MoveZeroes : BaseSpec({

    "Move Zeroes" {
        intArrayOf(0, 1, 0, 3, 12).moveZeroes() shouldBe intArrayOf(1, 3, 12, 0, 0)
        intArrayOf(0).moveZeroes() shouldBe intArrayOf(0)
    }
})

private fun IntArray.moveZeroes(): IntArray {
    if (this.size <= 1) return this

    // 移动0的次数
    var moveCnt = 0
    for (i in 0 until this.size) {
        if (this[i] == 0) {
            moveCnt++
            continue
        }
        if (moveCnt != 0) {
            this[i - moveCnt] = this[i]
        }
    }
    while (moveCnt != 0) {
        this[this.size - moveCnt] = 0
        moveCnt--
    }
    return this
}