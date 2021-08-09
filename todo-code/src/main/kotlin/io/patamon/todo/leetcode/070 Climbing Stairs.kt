package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 70. Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 *
 * Example 1:
 *
 * ```
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * ```
 *
 * Example 2:
 *
 * ```
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * ```
 *
 * =============================================================================================================
 *
 * # 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class ClimbingStairs : StringSpec({

    /**
     * [尾]递归法, 循环发
     */
    "ClimbingStairs" {
        0.climbStairs() shouldBe 0
        1.climbStairs() shouldBe 1
        2.climbStairs() shouldBe 2
        3.climbStairs() shouldBe 3
        4.climbStairs() shouldBe 5

        0.climbStairs2() shouldBe 0
        1.climbStairs2() shouldBe 1
        2.climbStairs2() shouldBe 2
        3.climbStairs2() shouldBe 3
        4.climbStairs2() shouldBe 5

        0.climbStairs3() shouldBe 0
        1.climbStairs3() shouldBe 1
        2.climbStairs3() shouldBe 2
        3.climbStairs3() shouldBe 3
        4.climbStairs3() shouldBe 5
    }

    /**
     * 斐波拉契序列
     */
    "finb" {
        1.finb() shouldBe 1
        2.finb() shouldBe 2
        3.finb() shouldBe 3
        4.finb() shouldBe 5
    }

    /**
     * 暴力枚举法
     */
    "enum" {
        0.enum() shouldBe 0
        1.enum() shouldBe 1
        2.enum() shouldBe 2
        3.enum() shouldBe 3
        4.enum() shouldBe 5
    }
})

/**
 * 递归
 */
private fun Int.climbStairs(): Int {
    when (this) {
        0 -> return 0
        1 -> return 1
        2 -> return 2
        3 -> return 3
    }
    return (this - 1).climbStairs() + (this - 2).climbStairs()
}

/**
 * 循环的方式
 */
private fun Int.climbStairs2(): Int {
    var temp = intArrayOf(0, 1, 2, 3)
    if (this <= 3) {
        return temp[this]
    }
    (4 .. this).forEach { i ->
        temp = temp.plus(temp[i -1] + temp[i - 2])
    }
    return temp[this]
}

/**
 * 循环的方式2
 */
private fun Int.climbStairs3(): Int {
    when (this) {
        0 -> return 0
        1 -> return 1
        2 -> return 2
        3 -> return 3
    }
    var a = 2
    var b = 3
    var tmp = 0
    for (i in 4 .. this) {
        tmp = a + b
        a = b
        b = tmp
    }
    return tmp
}

/**
 * 斐波那契公式
 */
private fun Int.finb(): Int {
    val sqrt5 = sqrt(5.0)
    val finb = ((1 + sqrt5) / 2).pow(this + 1.0) - ((1 - sqrt5) / 2).pow(this + 1.0)
    return (finb / sqrt5).toInt()
}

/**
 * 暴力枚举法, 天秀
 */
private fun Int.enum(): Int {
    var result = 0
    when (this) {
        1 -> result = 1
        2 -> result = 2
        3 -> result = 3
        4 -> result = 5
        5 -> result = 8
        6 -> result = 13
        7 -> result = 21
        8 -> result = 34
        9 -> result = 55
        10 -> result = 89
        11 -> result = 144
        12 -> result = 233
        13 -> result = 377
        14 -> result = 610
        15 -> result = 987
        16 -> result = 1597
        17 -> result = 2584
        18 -> result = 4181
        19 -> result = 6765
        20 -> result = 10946
        21 -> result = 17711
        22 -> result = 28657
        23 -> result = 46368
        24 -> result = 75025
        25 -> result = 121393
        26 -> result = 196418
        27 -> result = 317811
        28 -> result = 514229
        29 -> result = 832040
        30 -> result = 1346269
        31 -> result = 2178309
        32 -> result = 3524578
        33 -> result = 5702887
        34 -> result = 9227465
        35 -> result = 14930352
        36 -> result = 24157817
        37 -> result = 39088169
        38 -> result = 63245986
        39 -> result = 102334155
        40 -> result = 165580141
        41 -> result = 267914296
        42 -> result = 433494437
        43 -> result = 701408733
        44 -> result = 1134903170
        45 -> result = 1836311903
    }
    return result
}
