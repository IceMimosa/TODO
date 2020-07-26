package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *   053. Maximum Subarray (最大子序和)
 *   给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-07-19
 */
class MaximumSubarray: StringSpec({

    "Maximum Subarray" {
        intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).maxSubArray() shouldBe 6
    }

})

/**
 * 1. 贪心: 前面的小于0，就丢弃
 *
 * 2. 动态规划: 前面的元素大于0，就和当前元素相加
 * f(i) = max{ f(i-1) + ai, ai }
 */
private fun IntArray.maxSubArray(): Int {
    assert(this.isNotEmpty())
    var pre = 0
    var ans = this[0]
    for (num in this) {
        pre = Math.max(pre + num, num)
        ans = Math.max(pre, ans)
    }
    return ans
}

/**
 * TODO: 分治法求解, 线段树
 */
