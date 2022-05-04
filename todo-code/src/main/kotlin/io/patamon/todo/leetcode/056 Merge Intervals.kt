package io.patamon.todo.leetcode

import io.kotest.assertions.print.print
import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec
import io.patamon.todo.common.ListNode

/**
 * 56. Merge Intervals（合并区间）
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * * 示例1
 *
 * ```
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * ```
 *
 * 提示：
 *
 * * 1 <= intervals.length <= 10^4
 * * intervals[i].length == 2
 * * 0 <= starti <= endi <= 10^4
 */
class MergeIntervals : BaseSpec({

    "Merge Intervals" {
        arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
            .intervals() shouldBe arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18)).intervals()
        arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))
            .intervals() shouldBe arrayOf(intArrayOf(1, 5))
    }
})

private fun Array<IntArray>.intervals(): Array<IntArray> {
    if (this.size <= 1) return this
    // 先排序
    this.sortWith { o1, o2 -> o1[0] - o2[0] }

    var idx = 0
    val results = mutableListOf(this[0])
    for (i in 1 until this.size) {
        val a = results[idx]
        val b = this[i]
        if (b[0] > a[1]) {
            results.add(b)
            idx++
            continue
        }
        if (b[1] <= a[1]) {
            results[idx] = a
            continue
        }
        else {
            results[idx] = intArrayOf(a[0], b[1])
            continue
        }
    }
    return results.toTypedArray()
}
