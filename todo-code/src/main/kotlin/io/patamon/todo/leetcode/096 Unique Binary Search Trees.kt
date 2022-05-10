package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 096. Unique Binary Search Trees （不同的二叉搜索树）
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * * 示例1
 *
 * ```
 * 输入：n = 3
 * 输出：5
 *
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：n = 1
 * 输出：1
 * ```
 *
 * 提示：
 *
 * * 1 <= n <= 19
 */
class UniqueBinarySearchTrees : BaseSpec({

    "Unique Binary Search Trees" {
        1.numTrees() shouldBe 1
        3.numTrees() shouldBe 5

        1.numTrees2() shouldBe 1
        3.numTrees2() shouldBe 5
    }
})

// 递归 or 动态规划
private fun Int.numTrees(): Int {
    val dp = IntArray(this + 1)
    dp[0] = 1
    dp[1] = 1

    for (i in 2..this) {
        // 以 j 为 root, 两边的子树的笛卡尔积
        for (j in 1..i) {
            dp[i] += dp[j - 1] * dp[i - j]
        }
    }
    return dp[this]
}

/**
 * 卡塔兰数: https://baike.baidu.com/item/catalan/7605685?fr=aladdin
 *
 * C0 = 1, Cn = 2(2n + 1) / (n + 2) * C(n-1)
 */
private fun Int.numTrees2(): Int {
    var r = 1
    for (i in 0 until this) {
        r = r * 2 * (2 * i + 1) / (i + 2)
    }
    return r
}