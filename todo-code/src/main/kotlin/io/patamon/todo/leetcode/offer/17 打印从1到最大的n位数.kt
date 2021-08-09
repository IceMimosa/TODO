package io.patamon.todo.leetcode.offer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.math.pow

/**
 * Desc:
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020/7/26
 */
class _17 : StringSpec({

    "17 打印从1到最大的n位数" {
        // 本题需要考虑大数溢出的情况
        // 可以考虑返回: "1,2,3,4,5,6,7,8,9..."
        fun printNumbers(n: Int): IntArray {
            return IntArray(10.0.pow(n).toInt() - 1) { it + 1 }
        }

        printNumbers(1) shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }
})
