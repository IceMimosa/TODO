package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *  674. Longest Continuous Increasing Subsequence
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *  
 *
 * 注意：数组长度不会超过10000。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020/7/27
 */
class LongestContinuousIncreasingSubsequence : StringSpec({

    "674 Longest Continuous Increasing Subsequence" {
        intArrayOf(1, 3, 5, 4, 7).findLengthOfLCIS() shouldBe 3
        intArrayOf(1).findLengthOfLCIS() shouldBe 1
        intArrayOf(2, 2, 2, 2, 2).findLengthOfLCIS() shouldBe 1
    }
})

private fun IntArray.findLengthOfLCIS(): Int {
    if (this.isEmpty()) {
        return 0
    }
    var ans = 1
    var count = 1
    (1 until this.size).forEach { i ->
        if (this[i] > this[i - 1]) {
            count ++
        } else {
            count = 1
        }
        ans = Math.max(ans, count)
    }
    return ans
}
