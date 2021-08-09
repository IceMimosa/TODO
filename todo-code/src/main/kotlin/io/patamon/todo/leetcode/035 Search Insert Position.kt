package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * ```
 * Input: [1,3,5,6], 5
 * Output: 2
 * ```
 *
 * Example 2:
 *
 * ```
 * Input: [1,3,5,6], 2
 * Output: 1
 * ```
 *
 * Example 3:
 *
 * ```
 * Input: [1,3,5,6], 7
 * Output: 4
 * ```
 *
 * Example 4:
 *
 * ```
 * Input: [1,3,5,6], 0
 * Output: 0
 * ```
 *
 * =============================================================================================================
 *
 * # 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class SearchInsertPosition : StringSpec({

    /**
     * [commonForEach]
     */
    "直接循环法" {
        intArrayOf(1, 3, 5, 6).commonForEach(5) shouldBe 2
        intArrayOf(1, 3, 5, 6).commonForEach(2) shouldBe 1
        intArrayOf(1, 3, 5, 6).commonForEach(7) shouldBe 4
        intArrayOf(1, 3, 5, 6).commonForEach(0) shouldBe 0
        intArrayOf(1, 3).commonForEach(3) shouldBe 1
    }

    /**
     * [binarySearch]
     */
    "二分查找法" {
        intArrayOf(1, 3, 5, 6).binarySearch(5) shouldBe 2
        intArrayOf(1, 3, 5, 6).binarySearch(2) shouldBe 1
        intArrayOf(1, 3, 5, 6).binarySearch(7) shouldBe 4
        intArrayOf(1, 3, 5, 6).binarySearch(0) shouldBe 0
        intArrayOf(1, 3).binarySearch(3) shouldBe 1
    }

})

/**
 * 最直接的就是循环数组, 依次比较
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
private fun IntArray.commonForEach(target: Int): Int {
    for (i in 0 until this.size) {
        // 如果当前元素大于等于 target, 就返回当前元素的位置
        if (this[i] >= target) {
            return i
        }
    }
    return this.size
}

/**
 * 二分查找法
 *
 * 时间复杂度: O(log(n))
 * 空间复杂度: O(1)
 */
private fun IntArray.binarySearch(target: Int): Int {
    var low = 0
    var high = this.size - 1

    // 优化, 校验开头和结尾
    if (this.isEmpty()) return 0
    if (this[low] >= target) return 0
    if (this[high] == target) return this.size - 1
    if (this[high] < target) return this.size

    while (low <= high) {
        val mid = (low + high) ushr 1
        if (this[mid] == target) return mid
        else if (this[mid] > target) high = mid - 1
        else if (this[mid] < target) low = mid + 1
    }
    return low
}
