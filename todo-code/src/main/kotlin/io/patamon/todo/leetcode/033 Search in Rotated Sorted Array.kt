package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 033. Search in Rotated Sorted Array （搜索旋转排序数组）
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 * * 示例1
 *
 * ```
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：nums = [1], target = 0
输出：-1
 *
 * ```
 *
 * 提示：
 *
 * * 1 <= nums.length <= 5000
 * * -10^4 <= nums[i] <= 10^4
 * * nums 中的每个值都 独一无二
 * * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * * -10^4 <= target <= 10^4
 */
class SearchInRotatedSortedArray : BaseSpec({

    "Search in Rotated Sorted Array" {
        intArrayOf(5, 1, 3).search(3) shouldBe 2
        intArrayOf(4, 5, 6, 7, 0, 1, 2).search(0) shouldBe 4
        intArrayOf(5, 1, 3).search(5) shouldBe 0
        intArrayOf(1, 3).search(3) shouldBe 1
    }
})

private fun IntArray.search(target: Int): Int {
    if (this.isEmpty()) return -1

    var start = 0
    var end = this.size - 1
    while (start <= end) {
        val mid = start + ((end - start) ushr 1)
        if (this[mid] == target) return mid

        // 左半段, 有序
        if (this[start] <= this[mid]) {
            if (this[mid] < target) start = mid + 1
            else if (this[start] <= target) end = mid - 1
            else start = mid + 1
        }
        // 右半段, 有序
        else {
            if (this[mid] > target) end = mid - 1
            else if (this[end] >= target) start = end - 1
            else end = mid - 1
        }
    }
    return -1
}

