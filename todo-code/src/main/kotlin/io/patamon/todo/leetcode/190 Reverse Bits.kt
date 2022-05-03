package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 190. Reverse Bits （颠倒二进制位）
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *
 * * 示例1
 *
 * ```
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 * 因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 * ```
 *
 * 提示：
 *
 * * 输入是一个长度为 32 的二进制字符串
 *
 * 进阶:
 *
 * * 如果多次调用这个函数，你将如何优化你的算法？
 */
class ReverseBits : BaseSpec({

    "Reverse Bits" {
        43261596.reverseBits() shouldBe 964176192
        (-3).reverseBits() shouldBe -1073741825

        43261596.reverseBits2() shouldBe 964176192
        (-3).reverseBits2() shouldBe -1073741825
    }
})


/**
 * 时间复杂度: O(n)
 */
private fun Int.reverseBits(): Int {
    var target = 0
    var num = this
    for (i in 1 .. 32) {
        target = target shl 1
        target = target or (num and 1)
        num = num ushr 1
    }
    return target
}

/**
 * 时间复杂度: O(1)
 */
private fun Int.reverseBits2(): Int {
    val M1 = 0x55555555 // 01010101010101010101010101010101
    val M2 = 0x33333333 // 00110011001100110011001100110011
    val M4 = 0x0f0f0f0f // 00001111000011110000111100001111
    val M8 = 0x00ff00ff // 00000000111111110000000011111111

    var num = this
    num = num ushr 1 and M1 or ((num and M1) shl 1)
    num = num ushr 2 and M2 or ((num and M2) shl 2)
    num = num ushr 4 and M4 or ((num and M4) shl 4)
    num = num ushr 8 and M8 or ((num and M8) shl 8)
    num = num ushr 16 or (num shl 16)
    return num
}
