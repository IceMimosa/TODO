package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * # 058. Length of Last Word(最后一个单词的长度)
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-07-01
 */


class LengthOfLastWord: StringSpec({

    "Length of Last Word" {
        "Hello World".lengthOfLastWord() shouldBe 5
        "Hello World  ".lengthOfLastWord() shouldBe 5
    }

})

private fun String?.lengthOfLastWord(): Int {
    this ?: return 0

    var l = this.length - 1

    // 去除空格
    while (l >= 0) {
        if (this[l] == ' ') {
            l --
        } else {
            break
        }
    }

    // 找最后一个单词
    var result = 0
    while (l >= 0 && this[l] != ' ') {
        result ++
        l --
    }

    return result
}