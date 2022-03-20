package io.patamon.todo.leetcode.offer

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 10.1 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * * 参考：[io.patamon.todo.leetcode.ClimbingStairs]
 */
class _10_1 : BaseSpec({

    "斐波那契数列" {
        0.fib() shouldBe 0
        1.fib() shouldBe 1
        2.fib() shouldBe 1
        3.fib() shouldBe 2
        4.fib() shouldBe 3
        5.fib() shouldBe 5
    }
})

private fun Int.fib(): Int {
    if (this <= 1) return this
    var a = 0
    var b = 1
    for (i in 2 .. this) {
        b += a
        a = b - a
        b %= 1000000007
    }
    return b
}
