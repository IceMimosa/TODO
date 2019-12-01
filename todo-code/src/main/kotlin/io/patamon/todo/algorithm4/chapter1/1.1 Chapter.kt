package io.patamon.todo.algorithm4.chapter1

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc: 1.1 章节练习
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2019-12-01
 */
class Chapter11 : StringSpec({

    /**
     * 编写一段代码, 将一个正整数 N 用二进制表示, 并转换为一个 string 类型的 s
     */
    "1.1.9" {
        5.toBinaryString1() shouldBe "101"
        5.toBinaryString2() shouldBe "101"
    }
})

// 使用 %
fun Int.toBinaryString1(): String {
    if (this == 0) {
        return "0"
    }
    var i = this
    var s = ""
    while (i > 0) {
        s = "" + (i % 2) + s
        i /= 2
    }
    return s
}

// 使用位运算
fun Int.toBinaryString2(): String {
    if (this == 0) {
        return "0"
    }
    var i = this
    var s = ""
    while (i > 0) {
        s = "" + (i and 1) + s
        i = i shr 1
    }
    return s
}
