package io.patamon.todo.leetcode2000

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 2109. Adding Spaces to a String （向字符串添加空格）
 *
 * 给你一个下标从 0 开始的字符串 s ，以及一个下标从 0 开始的整数数组 spaces 。

 * 数组 spaces 描述原字符串中需要添加空格的下标。每个空格都应该插入到给定索引处的字符值 之前 。
 *
 * 例如，s = "EnjoyYourCoffee" 且 spaces = [5, 9] ，那么我们需要在 'Y' 和 'C' 之前添加空格，这两个字符分别位于下标 5 和下标 9 。因此，最终得到 "Enjoy Your Coffee" 。
 * 请你添加空格，并返回修改后的字符串。
 *
 * * 示例1
 *
 * ```
 * 输入：s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
 * 输出："Leetcode Helps Me Learn"
 * 解释：
 * 下标 8、13 和 15 对应 "LeetcodeHelpsMeLearn" 中加粗斜体字符。
 * 接着在这些字符前添加空格。
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：s = "icodeinpython", spaces = [1,5,7,9]
 * 输出："i code in py thon"
 * 解释：
 * 下标 1、5、7 和 9 对应 "icodeinpython" 中加粗斜体字符。
 * 接着在这些字符前添加空格。
 *
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：s = "spacing", spaces = [0,1,2,3,4,5,6]
 * 输出：" s p a c i n g"
 * 解释：
 * 字符串的第一个字符前可以添加空格。
 *
 * ```
 *
 * 提示：
 *
 * * 1 <= s.length <= 3 * 105
 * * s 仅由大小写英文字母组成
 * * 1 <= spaces.length <= 3 * 105
 * * 0 <= spaces[i] <= s.length - 1
 * * spaces 中的所有值 严格递增
 */
class AddingSpacesToAString : BaseSpec({

    "Adding Spaces to a String" {
        "LeetcodeHelpsMeLearn".addSpaces(intArrayOf(8, 13, 15)) shouldBe "Leetcode Helps Me Learn"
        "icodeinpython".addSpaces(intArrayOf(1, 5, 7, 9)) shouldBe "i code in py thon"
        "spacing".addSpaces(intArrayOf(0, 1, 2, 3, 4, 5, 6)) shouldBe " s p a c i n g"
    }
})

private fun String.addSpaces(spaces: IntArray): String {
    if (spaces.isEmpty()) return this

    val sb = StringBuilder()
    var j = 0
    for (i in 0 until this.length) {
        if (j < spaces.size && i == spaces[j]) {
            sb.append(" ")
            j++
        }
        sb.append(this[i])
    }
    return sb.toString()
}
