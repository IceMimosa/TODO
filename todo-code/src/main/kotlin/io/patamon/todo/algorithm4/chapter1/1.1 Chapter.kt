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

    /**
     * 编写一个静态方法 lg(), 接受一个整型参数 N, 返回不大于 log2(N) 最大整数
     *
     * 不使用 Math 库
     */
    "1.1.14" {
        // 实现1: 逆向
        fun lg1(num: Int): Int {
            var i = num shr 1
            while (i > num / i) {
                i = i shr 1
            }
            return i
        }

        lg1(4) shouldBe 2
        lg1(5) shouldBe 2
        lg1(13) shouldBe 3

        // 实现2: 正向
        fun lg2(num: Int): Int {
            var cnt = 0
            var i = num
            while (i != 1) {
                i = i shr 1
                cnt += 1
            }
            return cnt
        }

        lg2(4) shouldBe 2
        lg2(5) shouldBe 2
        lg2(13) shouldBe 3
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
