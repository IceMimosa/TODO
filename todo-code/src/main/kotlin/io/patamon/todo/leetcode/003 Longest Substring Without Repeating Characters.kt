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
class LongestSubstringWithoutRepeatingCharacters : StringSpec({

    "Longest Substring Without Repeating Characters" {
        "abcabcbb".lengthOfLongestSubstring() shouldBe 3
        "bbbbb".lengthOfLongestSubstring() shouldBe 1
        "pwwkew".lengthOfLongestSubstring() shouldBe 3
        " ".lengthOfLongestSubstring() shouldBe 1
        "a".lengthOfLongestSubstring() shouldBe 1
        "abba".lengthOfLongestSubstring() shouldBe 2
    }

    "Longest Substring Without Repeating Characters by Map" {
        "abcabcbb".lengthOfLongestSubstring2() shouldBe 3
        "bbbbb".lengthOfLongestSubstring2() shouldBe 1
        "pwwkew".lengthOfLongestSubstring2() shouldBe 3
        " ".lengthOfLongestSubstring2() shouldBe 1
        "a".lengthOfLongestSubstring2() shouldBe 1
        "abba".lengthOfLongestSubstring2() shouldBe 2
    }
})

/**
 * 滑动窗口, 使用 start 和 end
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
private fun String?.lengthOfLongestSubstring(): Int {
    this ?: return 0
    if (this.isEmpty()) {
        return 0
    }

    var maxLen = 1
    var start = 0
    var end = start + 1
    while (start < this.length && end < this.length) {

        var i = end - 1
        while (i >= start && this[i] != this[end]) {
            i --
        }
        if (i < start) {
            maxLen = Math.max(maxLen, end - start + 1)
            end ++
            continue
        }

        start = i + 1
        end = start + 1
    }
    return maxLen
}

/**
 * 使用 hashmap 优化
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(x)
 */
private fun String?.lengthOfLongestSubstring2(): Int {
    this ?: return 0
    if (this.isEmpty()) {
        return 0
    }

    val map = hashMapOf<Char, Int>()
    var maxLen = 1
    var i = 0
    var left = 0
    while (i < this.length) {

        if (map.contains(this[i])) {
            left = Math.max(left, map[this[i]]!! + 1)
        }

        map[this[i]] = i
        maxLen = Math.max(maxLen, i - left + 1)
        i ++
    }
    return maxLen
}
