package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.math.absoluteValue

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 7. Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example:
 *
 * ```
 * Input: 123
 * Output: 321
 * ```
 *
 * ```
 * Input: -123
 * Output: -321
 * ```
 *
 * ```
 * Input: 120
 * Output: 21
 * ```
 *
 * Note:
 *
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your
 * function returns 0 when the reversed integer overflows.
 *
 * =============================================================================================================
 *
 * # 7. 反转整数
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 *
 * 注意：假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/06
 */
class ReverseInteger : StringSpec({

    /**
     * 弹出/推入数字 + 溢出检查: [popPush]
     */
    "弹出/推入数字" {
        123.popPush() shouldBe 321
        (-123).popPush() shouldBe -321
        120.popPush() shouldBe 21
        2147483647.popPush() shouldBe 0
        (-2147483648).popPush() shouldBe 0
    }

    /**
     * 使用parseInt API法: [parseIntApi]
     */
    "ParseInt API方法" {
        123.parseIntApi() shouldBe 321
        (-123).parseIntApi() shouldBe -321
        120.parseIntApi() shouldBe 21
        2147483647.parseIntApi() shouldBe 0
        (-2147483648).parseIntApi() shouldBe 0
    }
})

/**
 * 弹出/推入数字 + 溢出检查
 *
 * 时间复杂度: O(log(n)), x大约有lg(x)个数字
 * 空间复杂度: O(1)
 */
private fun Int.popPush(): Int {
    var input = this
    var rev = 0
    while (input != 0) {
        // 去除末尾数字
        val pop = input % 10
        input /= 10
        // 溢出判断
        if (rev > Int.MAX_VALUE / 10 || (rev == Int.MAX_VALUE / 10 && pop == 7)) return 0
        if (rev < Int.MIN_VALUE / 10 || (rev == Int.MIN_VALUE / 10 && pop < -8)) return 0
        rev = rev * 10 + pop
    }
    return rev
}

/**
 * 使用parseInt API法
 */
private fun Int.parseIntApi(): Int {
    //val rev = Math.abs(this).toString().reversed()
    val rev = this.absoluteValue.toString().reversed()
    return try {
        if (this < 0) rev.toInt() * -1 else rev.toInt()
    } catch (e: NumberFormatException) {
        0
    }
}



