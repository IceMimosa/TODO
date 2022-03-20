package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 343. Integer Break（整数拆分）
 *
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 *
 * * 示例1
 *
 * ```
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * ```
 * 提示:
 *
 * * 2 <= n <= 58
 */
class IntegerBreak : BaseSpec({

    "Integer Break" {
        // 1.integerBreak() shouldBe 1
        2.integerBreak() shouldBe 1
        10.integerBreak() shouldBe 36

        2.integerBreak2() shouldBe 1
        10.integerBreak2() shouldBe 36
    }
})

private fun Int.integerBreak(): Int {
    if (this <= 3) return this - 1

    val dp = IntArray(this + 1)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    for (i in 4 .. this) {
        for (j in 1 .. i/2) {
            dp[i] = Math.max(dp[i], dp[j] * dp[i - j])
        }
    }
    return dp[this]
}

private fun Int.integerBreak2(): Int {
    if (this <= 3) return this - 1

    // 基于切绳子的思想，尽可能切多点3，对于最后的切法，要考虑到整体长度
    // 起码得切2，切1没有意义。
    // 或者切3，即绳子长度刚好可以被 3 整除
    // 或者切4，比如一直切3，最后余下1的长度，又因为前述提到不要切1，我们可以把前一段3和这一段1，合并起来，切成4。
    // 不能切5，因为可以将5切成2|3，可以得到乘积6

    var i = this
    var res: Long = 1
    while (i > 4) {
        res *= 3
        res %= 1000000007 // 考虑大数的情况
        i -= 3
    }

    // 乘以剩余线段长，只有2、3、4的可能
    return (res * i % 1000000007).toInt()
}