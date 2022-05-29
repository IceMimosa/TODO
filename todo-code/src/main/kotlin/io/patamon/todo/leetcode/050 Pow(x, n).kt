package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 050. Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n ）。
 *
 * * 示例1
 *
 * ```
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 * ```
 *
 * 提示：
 *
 * * -100.0 < x < 100.0
 * * -2^31 <= n <= 2^31-1
 * * -10^4 <= x^n <= 10^4
 */
class `Pow(x, n)` : BaseSpec({

    "Pow(x, n)" {
        2.00000.myPow(-2147483648) shouldBe 0.0
        2.00000.myPow(10) shouldBe 1024
        2.00000.myPow(-2) shouldBe 0.25
        1.00000.myPow(2147483647) shouldBe 1.0
    }
})

// 快速幂
private fun Double.myPow(n: Long): Double {
    if (this == 1.0 || this == 0.0 || n == 1L) return this
    if (n == 0L) return 1.0

    var res = 1.0
    var tmp = this
    var i = Math.abs(n)
    while (i > 0) {
        if (i and 1 == 1L) res *= tmp
        tmp *= tmp
        i = i ushr 1
    }
    return if (n > 0) res else 1 / res
}

