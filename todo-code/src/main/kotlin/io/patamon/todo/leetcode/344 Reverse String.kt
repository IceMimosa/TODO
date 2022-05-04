package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe


/**
 *
 * 344. 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * 提示：
 * 1 <= s.length <= 10^5
 * s[i] 都是 ASCII 码表中的可打印字符
 */
class ReverseString : StringSpec({

    "Reverse String" {
        charArrayOf('h','e','l','l','o').reverseString() shouldBe charArrayOf('o','l','l','e','h')
        charArrayOf('H','a','n','n','a','h').reverseString() shouldBe charArrayOf('h','a','n','n','a','H')
    }
})

private fun CharArray.reverseString(): CharArray {
    if (this.size <= 1) return this

    var start = 0
    var end = this.size - 1
    while (start < end) {
        val temp = this[start]
        this[start] = this[end]
        this[end] = temp

        start++
        end--
    }
    return this
}
