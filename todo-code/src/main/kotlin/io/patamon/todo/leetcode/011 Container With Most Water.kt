package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 011. Container With Most Water（盛最多水的容器）
 *
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * * 示例1
 *
 * ```
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：height = [1,1]
 * 输出：1
 * ```
 *
 * 提示：
 *
 * * n == height.length
 * * 2 <= n <= 10^5
 * * 0 <= height[i] <= 10^4
 */
class ContainerWithMostWater : BaseSpec({

    "Container With Most Water" {
        intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7).maxArea() shouldBe 49
        intArrayOf(1, 1).maxArea() shouldBe 1

        intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7).maxArea2() shouldBe 49
        intArrayOf(1, 1).maxArea2() shouldBe 1
    }
})


// 方法超时
private fun IntArray?.maxArea(): Int {
    if (this == null || this.size < 2) return 0

    var res = 0
    for (i in 1 until this.size) {
        for (j in 0 until i) {
            res = Math.max(res, Math.min(this[i], this[j]) * (i - j))
        }

    }
    return res
}

// 双指针
private fun IntArray?.maxArea2(): Int {
    if (this == null || this.size < 2) return 0

    var l = 0
    var r = this.size - 1
    var res = 0
    while (l < r) {
        val area = Math.min(this[l], this[r]) * (r - l)
        res = Math.max(res, area)
        if (this[l] <= this[r]) {
            l++
        } else {
            r--
        }
    }
    return res
}
