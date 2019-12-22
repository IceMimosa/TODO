package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 66. Plus One 👎
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * ```
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * ```
 *
 * Example 2:
 *
 * ```
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * ```
 *
 * =============================================================================================================
 *
 * # 66. 加一
 *
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class PlusOne : StringSpec({

    /**
     * [plusOne]
     */
    "plusOne" {
        intArrayOf(1, 2, 3).plusOne() shouldBe intArrayOf(1, 2, 4)
        intArrayOf(4, 3, 2, 1).plusOne() shouldBe intArrayOf(4, 3, 2, 2)
        intArrayOf(9, 9, 9, 9).plusOne() shouldBe intArrayOf(1, 0, 0, 0, 0)
    }

})

/**
 * 考虑几种情况
 *   1. 最后一个不是9
 *   2. 不全是9
 *   3. 全是9
 */
private fun IntArray.plusOne(): IntArray {
    val len = this.size
    for (i in len - 1 downTo 0) {
        if (this[i] < 9) {
            this[i]++
            return this
        }
        this[i] = 0
    }
    val arr = IntArray(len + 1)
    arr[0] = 1
    return arr
}
