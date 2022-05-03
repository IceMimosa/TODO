package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 202. Happy Number（快乐数）
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * * 示例1
 *
 * ```
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：n = 2
 * 输出：false
 * ```
 *
 * 提示：
 *
 * * 1 <= n <= 2^31 - 1
 */
class HappyNumber : BaseSpec({

    "Happy Number" {
        19.isHappy() shouldBe true
        2.isHappy() shouldBe false
        7.isHappy() shouldBe true
        116.isHappy() shouldBe false
    }
})


private fun Int.isHappy(): Boolean {
    if (this == 1) return true

    var result = this
    val cache = mutableSetOf<Int>()
    while (result != 1 && !cache.contains(result)) {
        cache.add(result)
        result = result.sum()
    }
    return result == 1
}

private fun Int.sum(): Int {
    var result = 0
    var num = this
    while (num > 0) {
        val x = num % 10
        result += x * x

        num /= 10
    }
    return result
}
