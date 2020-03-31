package io.patamon.todo.leetcode.offer

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 *  二维数组中的查找
 *
 *  在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *  请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-04-01
 */
class _04 : StringSpec({


    "04 二维数组中的查找" {
        arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30)
        ).findNumberIn2DArray(5) shouldBe true
    }

})

/**
 * 线性查找: 左下角 或者 右上角
 *
 * 时间: O(m + n)
 * 空间: O(1)
 */
private fun Array<IntArray>?.findNumberIn2DArray(target: Int): Boolean {
    if (this == null || this.isEmpty()) return false

    for (i in (this.size - 1 downTo 0)) {
        for (j in (0 until this[i].size)) {
            if (target == this[i][j]) return true
            else if (target > this[i][j]) continue
            else if (target < this[i][j]) break
        }
    }

    return false
}