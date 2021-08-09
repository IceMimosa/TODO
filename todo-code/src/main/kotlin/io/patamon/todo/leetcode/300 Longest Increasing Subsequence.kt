package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc: TODO
 *
 * # 300. Longest Increasing Subsequence (最长上升子序列)
 *
 *  给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 *  示例
 *  > 输入: [10,9,2,5,3,7,101,18]
 *  > 输出: 4
 *  > 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 *  说明:
 *    可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *    你算法的时间复杂度应该为 O(n2) 。
 *
 *  进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-01
 */


class LongestIncreasingSubsequence : StringSpec({

    "Longest Increasing Subsequence" {
        intArrayOf(10, 9, 2, 5, 3, 7, 101, 18).lengthOfLIS() shouldBe 4
    }

})

/**
 * 1. 简单的可以使用O(n^2)的迭代方法
 *
 * 2. 动态规则 (O(n^2))
 *   状态定义: dp[i] 表示 nums 前 i 个数字的最长子序列的长度
 *   初始状态: dp[i] 的所有元素默认都是1
 */
private fun IntArray?.lengthOfLIS(): Int {
    this ?: return 0
    val dp = IntArray(this.size) { 1 }
    var res = 0
    this.forEachIndexed { i, num ->
        (0 until i).forEach { j ->
            if (this[j] < num) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
        res = Math.max(res, dp[i])
    }
    return res
}
