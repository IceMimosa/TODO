package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 88. Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 *
 * ```
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * ```
 *
 * =============================================================================================================
 *
 * # 88. 合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/09/10
 */
class MergeSortedArray : StringSpec({

    /**
     * [merge]
     */
    "merge sorted array" {
        intArrayOf(1, 2, 3, 0, 0, 0).merge(3, intArrayOf(2, 5, 6), 3) shouldBe intArrayOf(1, 2, 2, 3, 5, 6)
    }

})

/**
 * 合并两个有序数组
 *
 * 解析: 第一感觉就是两个数组进行比较, 然后做插入的操作, 这样的效率明显不行
 *
 */
private fun IntArray.merge(m: Int, target: IntArray, n: Int): IntArray {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1
    while (i >= 0 && j >= 0) {
        if (this[i] >= target[j]) {
            this[k--] = this[i--]
        } else {
            this[k--] = target[j--]
        }
    }
    while (j >= 0) {
        this[k--] = target[j--]
    }
    return this
}
