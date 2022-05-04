package io.patamon.todo.leetcode

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 017. Letter Combinations of a Phone Number（电话号码的字母组合）
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * * 示例1
 *
 * ```
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：digits = ""
 * 输出：[]
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * ```
 *
 * 提示：
 *
 * * 0 <= digits.length <= 4
 * * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
class LetterCombinationsOfAPhoneNumber : BaseSpec({

    "Letter Combinations of a Phone Number" {
        "23".backtrack("", 0, mutableListOf()) shouldBe listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        "".backtrack("", 0, mutableListOf()) shouldBe emptyList()
        "2".backtrack("", 0, mutableListOf()) shouldBe listOf("a", "b", "c")
    }
})

private val letters = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

private fun String.backtrack(combination: String, index: Int, res: MutableList<String>): List<String> {
    if (this.isEmpty()) return res

    if (index == this.length) {
        res.add(combination)
    } else {
        for (c in letters["${this[index]}".toInt()]) {
            this.backtrack(combination + c, index + 1, res)
        }
    }
    return res
}
