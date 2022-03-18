package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 165. Compare Version Numbers(比较版本号)
 *
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
class CompareVersionNumbers : BaseSpec({

    "Compare Version Numbers" {
        "1.01".compareVersion("1.001") shouldBe 0
        "1.0".compareVersion("1.0.0") shouldBe 0
        "0.1".compareVersion("1.1") shouldBe -1
    }
})


private fun String.compareVersion(version: String): Int {
    val v1 = this.split(".")
    val v2 = version.split(".")

    val len = Math.max(v1.size, v2.size)
    for (i in 0 until len) {
        val a = if (i < v1.size) v1[i].toInt() else 0
        val b = if (i < v2.size) v2[i].toInt() else 0
        if (a == b) continue
        return a.compareTo(b)
    }
    return 0
}


