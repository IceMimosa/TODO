package io.patamon.todo.leetcode.offer

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 */
class _05 : BaseSpec({

    "替换空格" {
        "We are happy.".replaceSpace() shouldBe "We%20are%20happy."
    }
})

private fun String?.replaceSpace(): String {
    if (this.isNullOrEmpty()) return ""
    val sb = StringBuilder()
    for (c in this) {
        if (c == ' ') {
            sb.append("%20")
        } else {
            sb.append(c)
        }
    }
    return sb.toString()
}
