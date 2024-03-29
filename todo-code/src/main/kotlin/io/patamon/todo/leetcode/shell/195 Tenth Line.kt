package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 195. Tenth Line （第十行）
 *
 * 给定一个文本文件 file.txt，请只打印这个文件中的第十行。
 *
 * * 假设 file.txt 有如下内容：
 *
 * ```
 * Line 1
 * Line 2
 * Line 3
 * Line 4
 * Line 5
 * Line 6
 * Line 7
 * Line 8
 * Line 9
 * Line 10
 * ```
 *
 * * 你的脚本应当显示第十行：
 *
 * ```
 * Line 10
 * ```
 *
 * 提示：
 *
 * * 如果文件少于十行，你应当输出什么？
 * * 至少有三种不同的解法，请尝试尽可能多的方法来解题。
 *
 */
class TenthLine : BaseSpec({

    "Tenth Line" {
        "awk 'NR==10' file.txt"
        "sed -n 10p file.txt"
        "tail -n +10 file.txt|head -1"
    }
})
