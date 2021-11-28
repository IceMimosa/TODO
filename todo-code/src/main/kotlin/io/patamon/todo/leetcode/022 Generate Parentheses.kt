package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * Desc:
 *   22. Generate Parentheses (括号生成)
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 * 示例1:
 *
 * ```
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * ```
 *
 * 示例2:
 *
 * ```
 * 输入：n = 1
 * 输出：["()"]
 * ```
 *
 * 提示：1 <= n <= 8
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2021/11/28
 */
class `022 Generate Parentheses` : BaseSpec({

    "Generate Parentheses" {
        1.generateParenthesis() shouldBe listOf("()")
        3.generateParenthesis() shouldBe listOf("((()))","(()())","(())()","()(())","()()()")
    }
})

// dfs + 剪枝
private fun Int.generateParenthesis(forward: String = "", leftCount: Int = 0, rightCount: Int = 0, result: MutableList<String> = mutableListOf()): List<String> {
    val n = this
    if (leftCount < rightCount || leftCount > n || rightCount > n) {
        return result
    }
    if (leftCount == n && rightCount == n) {
        result.add(forward)
    }
    n.generateParenthesis("$forward(", leftCount + 1, rightCount, result)
    n.generateParenthesis("$forward)", leftCount, rightCount + 1, result)
    return result
}

// 按括号序列的长度递归
