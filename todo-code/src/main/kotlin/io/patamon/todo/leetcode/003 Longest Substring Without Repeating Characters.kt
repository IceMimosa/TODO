package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *
 * 003. Longest Substring Without Repeating Characters (无重复字符最大子串)
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
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
