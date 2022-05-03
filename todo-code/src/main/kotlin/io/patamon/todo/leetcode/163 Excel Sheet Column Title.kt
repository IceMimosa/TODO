package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 163. Excel Sheet Column Title（Excel表列名称）
 *
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * * 例如
 *
 * ```
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * ```
 *
 * * 示例1
 *
 * ```
 * 输入：columnNumber = 1
 * 输出："A"
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：columnNumber = 28
 * 输出："AB"
 * ```
 *
 * 提示：
 *
 * * 1 <= columnNumber <= 2^31 - 1
 */
class ExcelSheetColumnTitle : BaseSpec({

    "Excel Sheet Column Title" {
        1.convertToTitle() shouldBe "A"
        28.convertToTitle() shouldBe "AB"
        701.convertToTitle() shouldBe "ZY"
        2147483647.convertToTitle() shouldBe "FXSHRXW"
    }
})

private fun Int.convertToTitle(): String {
    var str = ""
    var num = this
    while (num > 0) {
        val mod = (num - 1) % 26
        str = (65 + mod).toChar() + str
        num = (num - 1) / 26
    }
    return str
}
