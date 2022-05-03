package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 191. Number of 1 Bits （Excel 表列序号）
 *
 * 请注意，
 *  * 在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
 *    并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 *  * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。
 *
 * * 示例1
 *
 * ```
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * ```
 *
 * 提示：
 *
 * * 输入必须是长度为 32 的 二进制串 。
 *
 * 进阶:
 *
 * * 如果多次调用这个函数，你将如何优化你的算法？
 */
class NumberOf1Bits : BaseSpec({

    "Number of 1 Bits" {
        11.hammingWeight() shouldBe 3
        128.hammingWeight() shouldBe 1
        (-3).hammingWeight() shouldBe 31

        11.hammingWeight2() shouldBe 3
        128.hammingWeight2() shouldBe 1
        (-3).hammingWeight2() shouldBe 31
    }
})


/**
 * 时间复杂度: O(n)
 */
private fun Int.hammingWeight(): Int {
    var cnt = 0
    var num = this
    while (num != 0) {
        cnt += num and 1
        num = num ushr 1
    }
    return cnt
}

/**
 * 时间复杂度: O(n), n为1的个数
 */
private fun Int.hammingWeight2(): Int {
    var cnt = 0
    var num = this
    while (num != 0) {
        num = num and (num - 1)
        cnt++
    }
    return cnt
}