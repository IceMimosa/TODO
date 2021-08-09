package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * Desc:
 *   136. Single Number (只出现一次的数字)
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * ```
 * 输入: [2,2,1]
 * 输出: 1
 * ```
 *
 * 示例 2:
 * ```
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * ```
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2021/8/10
 */
class `136 Single Number` : BaseSpec({

    "Single Number" {
        intArrayOf(2, 2, 1).singleNumber() shouldBe 1
        intArrayOf(4, 1, 2, 1, 2).singleNumber() shouldBe 4
    }
})


// 1. 使用异或
private fun IntArray?.singleNumber(): Int {
    this ?: return 0

    var num = 0
    for (n in this) {
        num = num xor n
    }
    return num
}

// 2. 使用map计数

