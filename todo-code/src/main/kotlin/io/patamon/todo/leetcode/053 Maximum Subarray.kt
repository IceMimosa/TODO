package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *   053. Maximum Subarray (最大子序和)
 *   给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
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
        intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).maxSubArray2() shouldBe 6
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
 * 动态规划, 优化一下就是贪心
 *
 * ## 1，动态规划解决
 * 这题是让求最大的连续子序和，如果不是连续的非常简单，只需要把所有的正数相加即可。
 * 但这里说的是连续的，中间可能掺杂负数，如果求出一个最大子序和在加上负数肯定要比原来小了。
 * 解这题最简单的一种方式就是使用动态规划。
 *
 * 我们先来了解一下动态规划的几个步骤
 *
 * 1. 确定状态
 * 2. 找到转移公式
 * 3. 确定初始条件以及边界条件
 * 4. 计算结果。

 * 最后一个不用看，只看前3个就行，因为前3个一旦确定，最后一个结果也就出来了。我们试着找一下

 * 1，定义 `dp[i]` 表示数组中前`i+1`（注意这里的i是从0开始的）个元素构成的连续子数组的最大和。
 *
 * 2，如果要计算前i+1个元素构成的连续子数组的最大和，也就是计算`dp[i]`，只需要判断`dp[i-1]`是大于0还是小于0。如果`dp[i-1]`大于0，
 * 就继续累加，`dp[i]=dp[i-1]+num[i]`。如果`dp[i-1]`小于0，我们直接把前面的舍弃，也就是说重新开始计算，否则会越加越小的，直接让`dp[i]=num[i]`。
 * 所以转移公式如下:
 *
 * ```
 * dp[i]=num[i]+max(dp[i-1],0);
 * ```
 *
 * 3，边界条件判断，当i等于0的时候，也就是前1个元素，他能构成的最大和也就是他自己，所以
 *
 * ```
 * dp[0]=num[0];
 * ```
 *
 * // https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn3cg3/
 */
private fun IntArray.maxSubArray2(): Int {
    assert(this.isNotEmpty())
    val dp = IntArray(this.size)
    // 边界条件
    dp[0] = this[0]
    for (i in 1 until this.size) {
        // 转移公式
        dp[i] = Math.max(0, dp[i - 1]) + this[i]
    }
    return dp.maxOrNull() ?: 0 // 可记录一个max临时变量
}

/**
 * TODO: 分治法求解, 线段树
 */
