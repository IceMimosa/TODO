package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *
 *  118. Pascal's Triangle (杨辉三角)
 *
 *  给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *  在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-04-03
 */
class PascalTriangle : StringSpec({


    "Pascal's Triangle" {
        0.generate() shouldBe emptyList<Int>()
        5.generate() shouldBe listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1), listOf(1, 4, 6, 4, 1))
    }

})

/**
 * 正常打印
 */
private fun Int.generate(): List<List<Int>> {
    if (this <= 0) return emptyList()

    val nums = mutableListOf<MutableList<Int>>()
    nums.add(mutableListOf(1))

    for (i in (1 until this)) {
        val preRow = nums[i - 1]
        val numsi = mutableListOf(1)

        for (j in (1 until i)) {
            numsi.add(preRow[j - 1] + preRow[j])
        }
        numsi.add(1)

        nums.add(numsi)
    }

    return nums.toList()
}
