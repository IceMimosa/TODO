package io.patamon.todo.algorithm4.chapter1

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *   简单二分查找
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2019-11-24
 */
class BinarySearch : StringSpec({

    "简单二分查找" {
        intArrayOf(3, 8, 12).myBinarySearch(3) shouldBe 0
        intArrayOf(1, 2, 2, 3, 4, 5).myBinarySearch(2) shouldBe 2
        intArrayOf(1, 2, 3, 4, 5).myBinarySearch(4) shouldBe 3
    }

})


private fun IntArray.myBinarySearch(e: Int): Int {
    // 排序, 数组必须有序
    this.sort()

    // 二分查找
    var low = 0
    var high = this.size - 1
    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            e > this[mid] -> { low = mid + 1 }
            e < this[mid] -> {  high = mid - 1 }
            else ->
                return mid
        }
    }
    return -1
}
