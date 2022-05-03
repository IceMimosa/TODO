package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import kotlin.math.pow

/**
 * 171. Excel Sheet Column Number （Excel 表列序号）
 *
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
 * 输入: columnTitle = "A"
 * 输出: 1
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入: columnTitle = "AB"
 * 输出: 28
 * ```
 *
 * 提示：
 *
 * * 1 <= columnTitle.length <= 7
 * * columnTitle 仅由大写英文组成
 * * columnTitle 在范围 ["A", "FXSHRXW"] 内
 */
class ExcelSheetColumnNumber : BaseSpec({

    "Excel Sheet Column Number" {
        "A".titleToNumber() shouldBe 1
        "AB".titleToNumber() shouldBe 28
        "ZY".titleToNumber() shouldBe 701
        "FXSHRXW".titleToNumber() shouldBe 2147483647
    }
})

private fun String.titleToNumber(): Int {
    var result = 0

    var mod = this.length - 1
    for (c in this) {
        result += (c.code - 65 + 1) * 26.toDouble().pow(mod).toInt()
        mod--
    }
    return result
}