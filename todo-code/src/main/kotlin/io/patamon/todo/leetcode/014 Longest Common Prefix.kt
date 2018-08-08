package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example:
 *
 * ```
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * ```
 *
 * ```
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * ```
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 * =============================================================================================================
 *
 * # 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * 说明：所有输入只包含小写字母 a-z 。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/08
 */
class LongestCommonPrefix: StringSpec({

    /**
     * Horizontal scanning: [horizontalScanning]
     */
    "Horizontal scanning" {
        arrayOf("flower","flow","flight").horizontalScanning() shouldBe "fl"
        arrayOf("dog","racecar","car").horizontalScanning() shouldBe ""
    }

})


/**
 * Horizontal scanning: 横向扫描
 *
 * 思路: 为了求 LCP(S1, S2, S3, ...), 将其转化成 LCP(LCP(LCP(S1, S2), S3), ...Sn)
 *
 * 时间复杂度: O(S), S为所有字符数. 最差的情况就是所有的string都相同, 这样就要比较S次.
 * 空间复杂度: O(1)
 */
private fun Array<String>.horizontalScanning(): String {
    if (this.isEmpty()) return ""
    // 1. 取出第一个串当做 prefix
    var prefix = this.first()

    // 2. 迭代数组
    for (i in 1 until this.size) {
        // 如果不是前缀就不断缩短 prefix
        while (!this[i].startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return ""
        }
    }
    return prefix
}


// TODO: 其他解法
