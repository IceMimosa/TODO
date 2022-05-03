package io.patamon.todo.leetcode

import io.patamon.todo.common.BaseSpec

/**
 * 193. Valid Phone Numbers （有效电话号码）
 *
 * 给定一个包含电话号码列表（一行一个电话号码）的文本文件 file.txt，写一个单行 bash 脚本输出所有有效的电话号码。
 * 你可以假设一个有效的电话号码必须满足以下两种格式： (xxx) xxx-xxxx 或 xxx-xxx-xxxx。（x 表示一个数字）
 * 你也可以假设每行前后没有多余的空格字符。
 *
 * * 假设 file.txt 有如下内容：
 *
 * ```
 * 987-123-4567
 * 123 456 7890
 * (123) 456-7890
 * ```
 *
 * * 你的脚本应当输出下列有效的电话号码：
 *
 * ```
 * 987-123-4567
 * (123) 456-7890
 * ```
 *
 * 提示：
 *
 * * 如果文件少于十行，你应当输出什么？
 * * 至少有三种不同的解法，请尝试尽可能多的方法来解题。
 *
 */
class ValidPhoneNumbers : BaseSpec({

    "ValidPhoneNumbers" {
        """grep -P '^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$' file.txt"""
        """awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt"""
        """gawk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt"""
    }
})
