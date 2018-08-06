package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 9. Palindrome Number
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example:
 *
 * ```
 * Input: 121
 * Output: true
 * ```
 *
 * ```
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * ```
 *
 * ```
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * ```
 *
 * Follow up:
 * Could you solve it without converting the integer to a string?
 *
 * =============================================================================================================
 *
 * # 9. 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/06
 */
class PalindromeNumber : StringSpec({


    /**
     * Reverse API 方法: [reverseApi]
     */
    "Reverse API 方法" {
        121.reverseApi() shouldBe true
        (-121).reverseApi() shouldBe false
        10.reverseApi() shouldBe false
        132.reverseApi() shouldBe false
        22.reverseApi() shouldBe true
        1.reverseApi() shouldBe true
    }

    /**
     * toString 后, 前后判断: [stringCheck]
     */
    "toString 后, 前后判断" {
        121.stringCheck() shouldBe true
        (-121).stringCheck() shouldBe false
        10.stringCheck() shouldBe false
        132.stringCheck() shouldBe false
        22.stringCheck() shouldBe true
        1.stringCheck() shouldBe true
    }

    "进阶: 数字校验" {
        121.numberCheck() shouldBe true
        (-121).numberCheck() shouldBe false
        10.numberCheck() shouldBe false
        132.numberCheck() shouldBe false
        22.numberCheck() shouldBe true
        1.numberCheck() shouldBe true
    }
})

/**
 * reverse api
 */
private fun Int.reverseApi() = this.toString().reversed() == this.toString()

/**
 * toString 后, 前后判断
 */
private fun Int.stringCheck(): Boolean {
    val input = this.toString()
    // start & end
    var start = 0
    var end = input.length - 1
    while (start < end) {
        if (input[start++] != input[end--]) return false
    }
    return true
}

/**
 * 进阶, 用数字校验
 *
 * 时间复杂度: O(log(n))
 * 空间复杂度: O(1)
 */
private fun Int.numberCheck(): Boolean {
    // 排除特殊情况
    // 1. 小于0 和 末尾是0 的都不是回文数
    if (this < 0 || (this % 10 == 0 && this != 0)) {
        return false
    }
    // 2. 个位数是回文数
    if (this < 10) {
        return true
    }

    var input = this
    var rev = 0
    while (input > rev) {
        rev = rev * 10 + input % 10
        input /= 10
    }

    // 如果输入数字长度为奇数, 那么需要将rev除以10来去除中位数, 因为中间那个数是多余的
    return input == rev || input == (rev / 10)
}