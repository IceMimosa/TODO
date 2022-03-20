package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 392. Is Subsequence（判断子序列）
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * * 示例1
 *
 * ```
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * ```
 */
class IsSubsequence : BaseSpec({

    "Is Subsequence" {
        ("abc".isSubsequence("ahbgdc") >= 0) shouldBe true
        ("axc".isSubsequence("ahbgdc") >= 0) shouldBe false
    }
})

private fun String?.isSubsequence(target: String?): Int {
    if (this.isNullOrBlank() && target.isNullOrBlank()) return 0
    if (this.isNullOrBlank()) return 0
    if (target.isNullOrBlank()) return -1

    var i = 0
    var j = 0
    while (i < this.length && j < target.length) {
        if (this[i] == target[j]) {
            i++
        }
        j++
    }
    return if (i == this.length) j - 1 else -1
}


