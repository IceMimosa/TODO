package io.patamon.todo.leetcode

import io.kotest.assertions.print.print
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.ListNode

/**
 * 15. 3Sum（三数之和）
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * * 示例1
 *
 * ```
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：nums = []
 * 输出：[]
 * ```
 *
 * 示例3
 *
 * ```
 * 输入：nums = [0]
 * 输出：[]
 * ```
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
class ThreeSum : BaseSpec({

    "Three Sum" {
        intArrayOf(-1, 0, 1, 2, -1, -4).threeSum()
        intArrayOf(1, 1, -2).threeSum()
        intArrayOf(-2, 0, 1, 1, 2).threeSum()

        intArrayOf(-1, 0, 1, 2, -1, -4).threeSum2()
        intArrayOf(1, 1, -2).threeSum2()
        intArrayOf(-2, 0, 1, 1, 2).threeSum2()
    }
})

// 1. 暴力迭代, 超时

// 2. map维护中间结果
private fun IntArray?.threeSum(): List<List<Int>> {
    if (this == null || this.size < 3) return emptyList()
    this.sort()

    if (this[0] > 0 || this[this.size - 1] < 0) return emptyList()
    val result = mutableListOf<List<Int>>() // set
    val map = hashMapOf<Int, Int>()
    for (i in 0 until this.size) {
        if (i > 0 && this[i] == this[i - 1]) {
            continue
        }
        map.clear()
        var j = i + 1
        while(j < this.size) {
            if (map.contains(-this[j])) {
                result.add(listOf(map[-this[j]]!!, -this[j] - map[-this[j]]!!, this[j]))
                map[this[i] + this[j]] = this[i]
                j++
                // 去重
                while (j < this.size && this[j] == this[j - 1]) {
                    j++
                }
            } else {
                map[this[i] + this[j]] = this[i]
                j++
            }
        }
    }
    return result
}

// 3. 双指针
private fun IntArray?.threeSum2(): List<List<Int>> {
    if (this == null || this.size < 3) return emptyList()
    this.sort()

    if (this[0] > 0 || this[this.size - 1] < 0) return emptyList()

    val result = mutableListOf<List<Int>>()
    for (i in 0 until this.size - 2) {
        if (this[i] > 0) return result
        if (i > 0 && this[i] == this[i - 1]) continue

        var l = i + 1
        var r = this.size - 1
        while (l < r) {
            val target = this[i] + this[l] + this[r]
            if (target > 0) {
                r--
                while (l < r && this[r] == this[r + 1]) r--
            } else if (target < 0) {
                l++
                while (l < r && this[l] == this[l - 1]) l++
            } else {
                result.add(listOf(this[i], this[l], this[r]))
                l++
                r--
                while (l < r && this[l] == this[l - 1]) l++
                while (l < r && this[r] == this[r + 1]) r--
            }
        }
    }
    return result
}
