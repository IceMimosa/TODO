package io.patamon.todo.leetcode2000

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 2110. Number of Smooth Descent Periods of a Stock （股票平滑下跌阶段的数目）
 *
 * 给你一个整数数组prices，表示一支股票的历史每日股价，其中prices[i]是这支股票第i天的价格。
 *
 * 一个 平滑下降的阶段定义为：对于连续一天或者多天，每日股价都比 前一日股价恰好少 1，这个阶段第一天的股价没有限制。
 *
 * 请你返回 平滑下降阶段的数目。
 *
 * * 示例1
 *
 * ```
 * 输入：prices = [3,2,1,4]
 * 输出：7
 * 解释：总共有 7 个平滑下降阶段：
 * [3], [2], [1], [4], [3,2], [2,1] 和 [3,2,1]
 * 注意，仅一天按照定义也是平滑下降阶段。
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：prices = [8,6,7,7]
 * 输出：4
 * 解释：总共有 4 个连续平滑下降阶段：[8], [6], [7] 和 [7]
 * 由于 8 - 6 ≠ 1 ，所以 [8,6] 不是平滑下降阶段。
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：prices = [1]
 * 输出：1
 * 解释：总共有 1 个平滑下降阶段：[1]
 * ```
 *
 * 提示：
 *
 * * 1 <= prices.length <= 10^5
 * * 1 <= prices[i] <= 10^5
 */
class NumberOfSmoothDescentPeriodsOfAStock : BaseSpec({

    "Number of Smooth Descent Periods of a Stock" {
        intArrayOf(3, 2, 1, 4).getDescentPeriods() shouldBe 7
        intArrayOf(8, 6, 7, 7).getDescentPeriods() shouldBe 4
        intArrayOf(1).getDescentPeriods() shouldBe 1
    }
})

private fun IntArray?.getDescentPeriods(): Long {
    if (this == null || this.isEmpty()) return 0L
    if (this.size == 1) return 1L

    var res = 1L
    val dp = IntArray(this.size) { 1 }
    for (i in 1 until this.size) {
        if (this[i - 1] - this[i] == 1) {
            dp[i] += dp[i - 1]
        }
        res += dp[i]
    }
    return res
}
