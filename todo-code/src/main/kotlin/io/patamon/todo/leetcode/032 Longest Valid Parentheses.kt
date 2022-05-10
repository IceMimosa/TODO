package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 32. Longest Valid Parentheses（最长有效括号）
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * * 示例1
 *
 * ```
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * ```
 *
 * * 示例3
 *
 * ```
 * 输入：s = ""
 * 输出：0
 * ```
 *
 * 提示：
 *
 * * 0 <= s.length <= 3 * 10^4
 * * s[i] 为 '(' 或 ')'
 */
class LongestValidParentheses : BaseSpec({

    "Longest Valid Parentheses" {
        "(()".longestValidParentheses() shouldBe 2
        "()".longestValidParentheses() shouldBe 2
        ")()())".longestValidParentheses() shouldBe 4
        "())".longestValidParentheses() shouldBe 2
    }

    "Longest Valid Parentheses with stack" {
        "(()".longestValidParenthesesStack() shouldBe 2
        "()".longestValidParenthesesStack() shouldBe 2
        ")()())".longestValidParenthesesStack() shouldBe 4
        "())".longestValidParenthesesStack() shouldBe 2
    }

    "Longest Valid Parentheses with loop" {
        "(()".longestValidParenthesesLoop() shouldBe 2
        "()".longestValidParenthesesLoop() shouldBe 2
        ")()())".longestValidParenthesesLoop() shouldBe 4
        "())".longestValidParenthesesLoop() shouldBe 2
    }
})

// 动态规划
private fun String?.longestValidParentheses(): Int {
    if (this == null || this.length < 2) return 0

    var res = 0
    val dp = IntArray(this.length)
    for (i in 1 until this.length) {
        if (this[i] == ')') {
            val lastIdx = dp.getOrZero(i - 1)

            if (this[i - 1] == '(') {
                dp[i] = 2 + dp.getOrZero(i - 2)
            }
            // 上一个有效括号
            else if (i - lastIdx - 1 >= 0 && this[i - lastIdx - 1] == '(') {
                dp[i] = 2 + lastIdx + dp.getOrZero(i - lastIdx - 2)
            }
        }
        res = Math.max(res, dp[i])
    }
    return res
}

private fun IntArray.getOrZero(i: Int): Int {
    if (i < 0 || i >= this.size) return 0
    return this[i]
}

// 栈
private fun String?.longestValidParenthesesStack(): Int {
    if (this == null || this.length < 2) return 0

    var res = 0
    val stack = java.util.ArrayDeque<Int>().also {
        it.push(-1)
    }
    for (i in 0 until this.length) {
        if (this[i] == '(') {
            stack.push(i)
        } else {
            stack.pop()
            if (stack.isEmpty()) {
                stack.push(i)
            } else {
                res = Math.max(res, i - stack.peek())
            }
        }
    }
    return res
}

// 左右各遍历一遍
private fun String?.longestValidParenthesesLoop(): Int {
    if (this == null || this.length < 2) return 0

    // 从左到右
    var res = 0
    var l = 0
    var r = 0
    for (i in 0 until this.length) {
        if (this[i] == '(') {
            l++
        } else {
            r++
        }
        if (l == r) {
            res = Math.max(res, 2 * r)
        } else if (r > l) {
            l = 0
            r = 0
        }
    }


    // 从右到左
    l = 0
    r = 0
    for (i in this.length - 1 downTo 0) {
        if (this[i] == '(') {
            l++
        } else {
            r++
        }

        if (l == r) {
            res = Math.max(res, 2 * l)
        } else if (l > r) {
            l = 0
            r = 0
        }
    }
    return res
}
