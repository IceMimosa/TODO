package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.TreeNode

/**
 * 169. Majority Element
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * * 示例1
 *
 * ```
 *  输入：nums = [3,2,3]
 *  输出：3
 * ```
 *
 * * 示例2
 *
 * ```
 *  输入：nums = [2,2,1,1,1,2,2]
 *  输出：2
 * ```
 *
 * 提示：
 *
 * * n == nums.length
 * * 1 <= n <= 5 * 10^4
 * * -10^9 <= nums[i] <= 10^9
 */
class MajorityElement : BaseSpec({

    "Majority Element" {
        intArrayOf(1, 1, 2).majorityElement() shouldBe 1
        intArrayOf(3, 2, 3).majorityElement() shouldBe 3
        intArrayOf(2, 2, 1, 1, 1, 2, 2).majorityElement() shouldBe 2
        intArrayOf(2, 2, 1, 1, 1, 1, 2).majorityElement() shouldBe 1
    }
})

// 1. hash 表

// 2. Boyer-Moore 投票算法
private fun IntArray.majorityElement(): Int {
    var count = 0
    var candidate: Int = -1
    for (n in this) {
        if (count == 0) {
            candidate = n
        }
        count += if (n == candidate) 1 else -1
    }
    return candidate
}