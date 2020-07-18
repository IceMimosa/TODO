package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * 125. Valid Palindrome(验证回文串)
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-07-18
 */
class ValidPalindrome : StringSpec({

    "Valid Palindrome" {
        "A man, a plan, a canal: Panama".isPalindrome() shouldBe true
        "race a car".isPalindrome() shouldBe false
    }

})

private fun String?.isPalindrome(): Boolean {
    this ?: return false

    var left = 0
    var right = this.length - 1
    while (left < right) {
        while (left < right && !this[left].isLetterOrDigit()) {
            left ++
        }
        while (right > left && !this[right].isLetterOrDigit()) {
            right --
        }

        if (this[left].toLowerCase() != this[right].toLowerCase()) {
            return false
        }
        left ++
        right --
    }
    return true
}