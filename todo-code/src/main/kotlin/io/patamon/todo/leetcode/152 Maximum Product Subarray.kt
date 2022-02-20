package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 152 Maximum Product Subarray (乘积最大子数组)
 *
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 * 示例 1:
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 提示:
 *
 * * 1 <= nums.length <= 2 * 104
 * * -10 <= nums[i] <= 10
 * * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 *
 */
class MaximumProductSubarray : BaseSpec({

    "Maximum Product Subarray" {
        intArrayOf(2, 3, -2, 4).maxProduct() shouldBe 6
        intArrayOf(-2, 0, -1).maxProduct() shouldBe 0
        intArrayOf(2, 3, -2, -3, 4).maxProduct() shouldBe 144
    }
})

private fun IntArray.maxProduct(): Int {

    val dpMax = IntArray(this.size)
    val dpMin = IntArray(this.size)
    dpMax[0] = this[0]
    dpMin[0] = this[0]
    var max = dpMax[0]
    for (i in 1 until this.size) {
        dpMax[i] = Math.max(dpMax[i - 1] * this[i], Math.max(dpMin[i - 1] * this[i], this[i]))
        dpMin[i] = Math.min(dpMax[i - 1] * this[i], Math.min(dpMin[i - 1] * this[i], this[i]))
        max = Math.max(max, dpMax[i])
    }
    return max
}
