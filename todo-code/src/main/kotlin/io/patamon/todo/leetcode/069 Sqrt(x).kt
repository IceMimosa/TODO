package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 69. Sqrt(x)
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * ```
 * Input: 4
 * Output: 2
 * ```
 *
 * Example 2:
 *
 * ```
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 * ```
 *
 * =============================================================================================================
 *
 * # 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class SqrtX : StringSpec({

    /**
     * [sqrtX]
     */
    "sqrtX" {
        4.sqrtX() shouldBe 2
        8.sqrtX() shouldBe 2
        25.sqrtX() shouldBe 5
        30.sqrtX() shouldBe 5
    }


    /**
     * [sqrtX2]
     */
    "sqrtX2" {
        4.sqrtX2() shouldBe 2
        8.sqrtX2() shouldBe 2
        25.sqrtX2() shouldBe 5
        30.sqrtX2() shouldBe 5
    }
})

/**
 * 求 x 的平方根
 *
 * 折半法
 */
private fun Int.sqrtX(): Int {
    if (this == 0) return 0
    // 使用 long 类型, 防止 i*i 超出 int 类型
    var i: Long = this.toLong()
    // while (i * i > this) { // 可以用除法解决
    while (i > this / i) {
        // 取 i ~ (this/i) 的中间
        // 这里是可以求证: i <= (i + this / i) / 2
        i = (i + this / i) / 2
    }
    return i.toInt()
}

/**
 * 二分法
 */
private fun Int.sqrtX2(): Int {
    if (this == 0) return 0
    var start = 1
    var end = Int.MAX_VALUE
    while (start < end) {
        val mid = start + (end - start) / 2
        // 找到了结果
        if (mid <= this / mid && (mid + 1) > this / (mid + 1)) {
            return mid
        }
        // mid*mid > this
        else if (mid > this / mid) {
            end = mid
        }
        // (mid+1)*(mid+1) <= this
        else {
            start = mid + 1
        }
    }
    return start
}
