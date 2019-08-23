package io.patamon.todo.utils

import java.util.*

/**
 * Desc: 简单的数学表达式引擎, 没有小数相关的逻辑
 *
 * @see https://github.com/scireum/parsii
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2019-05-09
 */
object MathExpression {

    /**
     * 计算表达式的值
     */
    @JvmStatic
    fun calculate(expr: String): Int {
        val logic = parseExpr(expr).reversed()
        if (logic.isEmpty()) {
            throw RuntimeException("expr is incorrect.")
        }
        if (logic.size == 1) {
            return logic.first().toInt()
        }

        // 计算
        val stack = Stack<String>()
        stack.addAll(logic)
        val resultStack = Stack<Int>()
        while (stack.isNotEmpty()) {
            val char = stack.pop()
            when (char.first()) {
                in '0' .. '9' -> {
                    val char2 = stack.pop()
                    when (char2.first()) {
                        in '0' .. '9' -> {
                            val op = stack.pop().first()
                            resultStack.push(calculate(char.toInt(), char2.toInt(), op))
                        }
                        else -> {
                            resultStack.push(calculate(resultStack.pop(), char.toInt(), char2.first()))
                        }
                    }
                }
                else -> {
                    resultStack.push(calculate(resultStack.pop(), resultStack.pop(), char.first()))
                }
            }
        }
        return resultStack.pop()
    }

    private fun calculate(num1: Int, num2: Int, op: Char): Int {
        return when (op) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> num1 / num2
            else -> {
                throw RuntimeException("expr is incorrect.")
            }
        }
    }

    /**
     * 将表达式转换成计算逻辑栈
     *
     * 如: (10+1)*3+1*2 => [10, 1, +, 3, *, 1, 2, *, +]
     */
    private fun parseExpr(expr: String): Stack<String> {
        val stack = Stack<String>()
        if (expr.isBlank()) {
            return stack
        }
        val operator = Stack<String>()

        var i = 0
        while (i < expr.length) {
            when (val it = expr[i]) {
                ' ' -> {
                }
                in '0'..'9' -> {
                    var digital = "$it"
                    while (i + 1 < expr.length && expr[i + 1] in '0'..'9') {
                        digital += expr[i + 1]
                        i++
                    }
                    stack.push(digital)
                }
                ')' -> {
                    var o = operator.pop()
                    while (o != "(") {
                        stack.push(o)
                        o = operator.pop()
                    }
                }
                else -> {
                    // priority: */ > +-
                    if (operator.size > 0 && (it == '+' || it == '-')) {
                        val last = operator.lastElement()
                        if (last == "*" || last == "/") {
                            while (operator.isNotEmpty()) {
                                stack.push(operator.pop())
                            }
                        }
                    }
                    operator.push("$it")
                }
            }
            i++
        }
        while (operator.isNotEmpty()) {
            stack.push(operator.pop())
        }
        return stack
    }
}