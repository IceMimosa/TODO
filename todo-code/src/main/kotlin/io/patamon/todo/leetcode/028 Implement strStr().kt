package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 28. Implement strStr()
 *
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * ```
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * ```
 *
 * Example 2:
 *
 * ```
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * ```
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 *
 * =============================================================================================================
 *
 * # 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 *
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class ImplementStrStr : StringSpec({

    /**
     * [strStr]
     */
    "双指针法" {
        "hello".strStr("ll") shouldBe 2
        "hella".strStr("la") shouldBe 3
        "aaaaa".strStr("bba") shouldBe -1
        "aaaaa".strStr("") shouldBe 0

        "hello".strStr2("ll") shouldBe 2
        "hella".strStr2("la") shouldBe 3
        "aaaaa".strStr2("bba") shouldBe -1
        "aaaaa".strStr2("") shouldBe 0
    }
})

/**
 * 比较直观的写法, 利用两个下标去移动、比较
 *
 * 时间复杂度: O(m * n)
 * 空间复杂度: O(1)
 */
private fun String.strStr(needle: String): Int {
    if (this.length < needle.length) return -1
    if (needle.isEmpty()) return 0

    var i = 0
    var j = 0
    while (i < this.length) {
        exit@
        while (j < needle.length) {
            // 如果不相等, i退到下一个元素, j初始化到0. 并且结束 needle 的循环
            if (this[i] != needle[j]) {
                i = i - j + 1
                j = 0
                break@exit
            }
            // 否则 i 和 j 继续前进
            else {
                i++
                j++
            }
        }
        // 如果发现 j 到头了, 退出, 说明找到了
        if (j == needle.length) {
            break
        }
    }
    // j 如果到头了, 表示找到了
    return if (j == needle.length) i - needle.length else -1
}

/**
 * 思路相同, 代码简化一下
 */
private fun String.strStr2(needle: String): Int {
    if (this.length < needle.length) return -1
    if (needle.isEmpty()) return 0

    for (i in 0 .. this.length) {
        for (j in 0 .. needle.length) {
            // 如果 j 到头了, 说明找到了, 直接return
            if (j == needle.length) return i
            // 优化点: 发现剩余的不够长, 说明没找到
            if (i + j == this.length) return -1
            // 某个位置的字符不相等, 退出 needle 循环
            if (this[i + j] != needle[j]) break
        }
    }
    return -1
}
