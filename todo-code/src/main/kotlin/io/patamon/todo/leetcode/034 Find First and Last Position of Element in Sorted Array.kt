package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 034. Find First and Last Position of Element in Sorted Array （在排序数组中查找元素的第一个和最后一个位置）
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * * 示例1
 *
 * ```
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * ```
 *
 * 提示：
 *
 * * 0 <= nums.length <= 10^5
 * * -10^9 <= nums[i] <= 10^9
 * * nums 是一个非递减数组
 * * -10^9 <= target <= 10^9
 */
class FindFirstAndLastPositionOfElementInSortedArray : BaseSpec({

    "Find First and Last Position of Element in Sorted Array" {
        intArrayOf(0, 0, 0, 1, 2, 3).searchRange(0) shouldBe intArrayOf(0, 2)
        intArrayOf(1, 1).searchRange(1) shouldBe intArrayOf(0, 1)
        intArrayOf(1, 3).searchRange(1) shouldBe intArrayOf(0, 0)
        intArrayOf(5, 7, 7, 8, 8, 10).searchRange(8) shouldBe intArrayOf(3, 4)
        intArrayOf(5, 7, 7, 8, 8, 10).searchRange(6) shouldBe intArrayOf(-1, -1)
        intArrayOf().searchRange(0) shouldBe intArrayOf(-1, -1)
    }
})

private fun IntArray.searchRange(target: Int): IntArray {
    var first = -1
    var last = -1

    var start = 0
    var end = this.size - 1
    while (start <= end) {
        val mid = start + (end - start) / 2

        // 记录第一个和最后一个
        if (this[start] == target && first == -1) first = start
        if (this[end] == target && last == -1) last = end

        if (this[mid] < target) {
            start = mid + 1
        } else if (this[mid] > target) {
            end = mid - 1
        } else {
            if (this[start] == target && this[end] == target) {
                break
            } else if (this[start] == target) {
                end--
            } else {
                start++
            }
        }
    }

    if (first != -1 && last != -1) return intArrayOf(first, last)
    if (first != -1) return intArrayOf(first, first)
    return intArrayOf(last, last)
}
