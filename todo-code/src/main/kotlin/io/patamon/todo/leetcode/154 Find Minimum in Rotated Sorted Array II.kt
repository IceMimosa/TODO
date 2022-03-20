package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 154. Find Minimum in Rotated Sorted Array II（寻找旋转排序数组中的最小值 II）
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 你必须尽可能减少整个过程的操作步骤。
 *
 */
class FindMinimuminRotatedSortedArrayII : BaseSpec({

    "Find Minimum in Rotated Sorted Array II" {
        intArrayOf(1, 3, 5).minArray() shouldBe 1
        intArrayOf(3, 4, 5, 1, 2).minArray() shouldBe 1
        intArrayOf(2, 2, 2, 0, 1).minArray() shouldBe 0
        intArrayOf(1, 2, 2, 3, 4).minArray() shouldBe 1

        intArrayOf(10, 1, 10, 10, 10).minArray2() shouldBe 1
        intArrayOf(3, 3, 1, 3).minArray2() shouldBe 1
        intArrayOf(1, 3, 5).minArray2() shouldBe 1
        intArrayOf(3, 4, 5, 1, 2).minArray2() shouldBe 1
        intArrayOf(2, 2, 2, 0, 1).minArray2() shouldBe 0
        intArrayOf(1, 2, 2, 3, 4).minArray2() shouldBe 1
    }
})

// 直接遍历
private fun IntArray?.minArray(): Int {
    if (this == null || this.isEmpty()) return -1
    for (i in 1 until this.size) {
        if (this[i] < this[i - 1]) {
            return this[i]
        }
    }
    return this[0]
}

// 二分
private fun IntArray?.minArray2(): Int {
    if (this == null || this.isEmpty()) return -1
    var i = 0
    var j = this.size - 1
    while (i < j) {
        val mid = (j - i) / 2 + i
        if (mid >= 1 && this[mid] < this[mid - 1]) return this[mid]
        if (this[mid] < this[j]) j = mid
        else if (this[mid] > this[j]) i = mid + 1
        else j--
    }
    return this[i]
}
