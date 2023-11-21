package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 42. Trapping Rain Water（接雨水）
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 */
class TrappingRainWater : BaseSpec({

    "Trapping Rain Water" {
        intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1).trap() shouldBe 6
        intArrayOf(4, 2, 0, 3, 2, 5).trap() shouldBe 9
    }
})


private fun IntArray.trap(): Int {
    if (this.size <= 2) return 0
    var left = 0
    var leftMax = this[left]

    var right = this.size - 1
    var rightMax = this[right]

    left++
    right--
    var res = 0
    while (left <= right) {
        leftMax = Math.max(leftMax, this[left])
        rightMax = Math.max(rightMax, this[right])

        if (leftMax <= rightMax) {
            res += leftMax - this[left]
            left++
        } else {
            res += rightMax - this[right]
            right--
        }
    }
    return res
}
