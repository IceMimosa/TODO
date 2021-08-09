package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 67. Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 *
 * Example 1:
 *
 * ```
 * Input: a = "11", b = "1"
 * Output: "100"
 * ```
 *
 * Example 2:
 *
 * ```
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * ```
 *
 * =============================================================================================================
 *
 * # 67. 二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class AddBinary : StringSpec({

    "AddBinary" {
        addBinary("1010", "1011") shouldBe "10101"
        addBinary("11", "1") shouldBe "100"
    }

})

/**
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
private fun addBinary(a: String, b: String): String {
    val aLen = a.length
    val bLen = b.length
    if (aLen == 0) return b
    if (bLen == 0) return a

    val sb = StringBuilder()
    var i = aLen - 1
    var j = bLen -1
    var c = 0 // 进位
    while (i >= 0 || j >= 0) {
        if (i >=0 ) c += a[i] - '0'
        if (j >=0 ) c += b[j] - '0'
        sb.append("${c % 2}")

        // 除以2, 进入下一位累加
        c = c shr 1

        i -= 1
        j -= 1
    }
    val result = sb.reverse().toString()
    return if (c > 0) "1$result" else result
}
