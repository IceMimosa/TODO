package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 *  118. Pascal's Triangle 2 (杨辉三角 2)
 *
 *  给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *  在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-04-03
 */
class PascalTriangle2 : StringSpec({


    "Pascal's Triangle 2" {
        0.getRow() shouldBe listOf(1)
        4.getRow() shouldBe listOf(1, 4, 6, 4, 1)
    }

})

private fun Int.getRow(): List<Int> {
    if (this < 0) return emptyList()

    val nums = IntArray(this + 1)

    for (i in (0 .. this)) {
        nums[i] = 1
        for (j in (i downTo 2)) { // 从后往前遍历
            nums[j - 1] = nums[j - 1] + nums[j - 2]
        }
    }

    return nums.toList()
}
