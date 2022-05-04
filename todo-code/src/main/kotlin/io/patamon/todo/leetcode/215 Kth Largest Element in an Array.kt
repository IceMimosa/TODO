package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import java.util.*

/**
 * 215. Kth Largest Element in an Array（数组中的第K个最大元素）
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * * 示例1
 *
 * ```
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * ```
 *
 * 提示：
 *
 * * 1 <= k <= nums.length <= 10^4
 * * -10^4 <= nums[i] <= 10^4
 */
class KthLargestElementInAnArray : BaseSpec({

    "Kth Largest Element in an Array" {
        intArrayOf(3, 2, 1, 5, 6, 4).findKthLargest(2) shouldBe 5
        intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6).findKthLargest(4) shouldBe 4

        intArrayOf(3, 2, 1, 5, 6, 4).findKthLargest2(2) shouldBe 5
        intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6).findKthLargest2(4) shouldBe 4
    }
})

// 用库排序
private fun IntArray.findKthLargest(k: Int): Int {
    this.sort()
    return this[this.size - k]
}

// 最小堆
private fun IntArray.findKthLargest2(k: Int): Int {
    val heap = PriorityQueue<Int>()
    for (n in this) {
        if (heap.size < k) {
            heap.add(n)
        }
        else if (heap.peek() < n) {
            heap.poll()
            heap.add(n)
        }
    }
    return heap.peek()
}
