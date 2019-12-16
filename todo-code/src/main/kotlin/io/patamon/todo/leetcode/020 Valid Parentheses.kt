package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.util.*

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 * An input string is valid if:
 *
 *   1. Open brackets must be closed by the same type of brackets.
 *   2. Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * ============================================================================================================
 *
 * # 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 * 有效字符串需满足：
 *
 *   1. 左括号必须用相同类型的右括号闭合。
 *   2. 左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例1:
 *
 * ```
 * 输入: "()"
 * 输出: true
 * ```
 *
 * 示例2:
 *
 * ```
 * 输入: "()[]{}"
 * 输出: true
 * ```
 *
 * 示例3:
 *
 * ```
 * 输入: "(]"
 * 输出: false
 * ```
 *
 * 示例4:
 *
 * ```
 * 输入: "([)]"
 * 输出: false
 * ```
 *
 * 示例5:
 *
 * ```
 * 输入: "{[]}"
 * 输出: true
 * ```
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class ValidParentheses: StringSpec({

    "辅助栈法" {
        "()".validParenthesesWithStack()     shouldBe true
        "()[]{}".validParenthesesWithStack() shouldBe true
        "(]".validParenthesesWithStack()     shouldBe false
        "([)]".validParenthesesWithStack()   shouldBe false
        "{[]}".validParenthesesWithStack()   shouldBe true
        "{".validParenthesesWithStack()   shouldBe false
    }

})

private fun String?.validParenthesesWithStack(): Boolean {
    this ?: return false
    val stack = ArrayDeque<Char>()
    var valid = true
    this.forEach {
        if (!valid) {
            return@forEach
        }
        when (it) {
            '{', '[', '(', '<' -> stack.push(it)
            '}' -> valid = stack.isNotEmpty() && stack.pop() == '{'
            ']' -> valid = stack.isNotEmpty() && stack.pop() == '['
            ')' -> valid = stack.isNotEmpty() && stack.pop() == '('
            '>' -> valid = stack.isNotEmpty() && stack.pop() == '<'
        }
    }
    return stack.isEmpty() && valid
}
