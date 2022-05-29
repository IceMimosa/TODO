package io.patamon.todo.leetcode2000

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 2108. Find First Palindromic String in the Array （找出数组中的第一个回文字符串）
 *
 * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
 *
 * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
 *
 * * 示例1
 *
 * ```
 * 输入：words = ["abc","car","ada","racecar","cool"]
 * 输出："ada"
 * 解释：第一个回文字符串是 "ada" 。
 * 注意，"racecar" 也是回文字符串，但它不是第一个。
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：words = ["notapalindrome","racecar"]
 * 输出："racecar"
 * 解释：第一个也是唯一一个回文字符串是 "racecar" 。
 *
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：words = ["def","ghi"]
 * 输出：""
 * 解释：不存在回文字符串，所以返回一个空字符串。
 *
 * ```
 *
 * 提示：
 *
 * * 1 <= words.length <= 100
 * * 1 <= words[i].length <= 100
 * * words[i] 仅由小写英文字母组成
 */
class FindFirstPalindromicStringInTheArray : BaseSpec({

    "Find First Palindromic String in the Array" {
        arrayOf("abc", "car", "ada", "racecar", "cool").firstPalindrome() shouldBe "ada"
        arrayOf("notapalindrome", "racecar").firstPalindrome() shouldBe "racecar"
        arrayOf("def", "ghi").firstPalindrome() shouldBe ""
    }
})

private fun Array<String>.firstPalindrome(): String {
    if (this.isEmpty()) return ""
    for (str in this) {
        if (str.isRe()) return str
    }
    return ""
}

private fun String?.isRe(): Boolean {
    if (this == null || this.length <= 1) return true
    var i = 0
    var j = this.length - 1
    while (i < j) {
        if (this[i] != this[j]) return false
        i++
        j--
    }
    return true
}
