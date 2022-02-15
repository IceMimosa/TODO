package io.patamon.todo.leetcode.interview

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.math.floor

/**
 * Desc: 排序算法
 *
 *
 * 插入排序: 直接插入排序, 希尔排序
 * 选择排序: 简单选择排序, 堆排序
 * 交换排序: 冒泡排序, 快速排序
 * 归并排序
 * 基数排序
 *
 *
 * 参考:
 *   1. https://mp.weixin.qq.com/s/IARShW-67PbcQd6AKMeAsw
 *   2. https://github.com/MisterBooo/Article
 *
 */

class SortAlgorithm : StringSpec({


    "Sort Algorithm" {

        arrayOf(3, 1, 5, 7, 2, 4, 9, 6).sortByInsert() shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 9)
        arrayOf(3, 1, 5, 7, 2, 4, 9, 6).sortByShell() shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 9)
        arrayOf(3, 1, 5, 7, 2, 4, 9, 6).sortBySelect() shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 9)
        arrayOf(3, 1, 5, 7, 2, 4, 9, 6).sortBySelectWithMax() shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 9)
        arrayOf(3, 1, 5, 7, 2, 4, 9, 6).sortByBubble() shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 9)
        arrayOf(3, 1, 5, 7, 2, 4, 9, 6).sortByQuick() shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 9)
        arrayOf(3, 1, 5, 7, 2, 4, 9, 6).sortByMerge() shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 9)
        arrayOf(3, 1, 5, 7, 2, 4, 9, 6).sortByHeap() shouldBe arrayOf(1, 2, 3, 4, 5, 6, 7, 9)
    }

})


/**
 * 直接插入排序
 */
fun Array<Int>?.sortByInsert(): Array<Int> {
    if (this == null || this.size <= 1) return this ?: emptyArray()

    for (i in (1 until this.size)) {
        if (this[i] >= this[i - 1]) continue

        val temp = this[i]
        var j = i - 1
        while (j >= 0 && this[j] > temp) {
            this[j + 1] = this[j]
            j--
        }
        this[j + 1] = temp
    }
    return this
}


/**
 * 希尔排序
 */
fun Array<Int>?.sortByShell(): Array<Int> {
    if (this == null || this.size <= 1) return this ?: emptyArray()

    // gap 一开始也可以选择 n/2
    var gap = 1
    while (gap < this.size) {
        gap = gap * 3 + 1
    }

    while (gap > 0) {

        for (i in (gap until this.size)) {
            val temp = this[i]
            var j = i - gap
            while (j >= 0 && this[j] > temp) {
                this[j + gap] = this[j]
                j -= gap
            }
            this[j + gap] = temp
        }
        gap = floor(gap / 3.0).toInt()
    }
    return this
}

/**
 * 选择排序
 */
fun Array<Int>?.sortBySelect(): Array<Int> {
    if (this == null || this.size <= 1) return this ?: emptyArray()

    for (i in (0 until this.size - 1)) {
        // 选出min的位置
        var min = i
        for (j in (i + 1 until this.size)) {
            if (this[j] < this[min]) {
                min = j
            }
        }

        if (i != min) {
            val temp = this[i]
            this[i] = this[min]
            this[min] = temp
        }
    }
    return this
}

fun Array<Int>?.sortBySelectWithMax(): Array<Int> {
    if (this == null || this.size <= 1) return this ?: emptyArray()

    for (i in (0 until this.size / 2)) {
        var min = i
        var max = i
        for (j in (i + 1 until this.size - i)) {
            if (this[j] < this[min]) {
                min = j; continue
            }
            if (this[j] > this[max]) {
                max = j
            }
        }

        if (i != min) {
            val temp = this[i]
            this[i] = this[min]
            this[min] = temp
        }
        val temp = this[this.size - i - 1]
        this[this.size - i - 1] = this[max]
        this[max] = temp
    }
    return this
}


fun Array<Int>?.sortByBubble(): Array<Int> {
    if (this == null || this.size <= 1) return this ?: emptyArray()

    for (i in (1 until this.size)) {
        // 如果已经有顺序了, 直接退出
        var flag = true // flag 也可以设置为交换的位置

        for (j in (0 until this.size - i)) {
            if (this[j] > this[j + 1]) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp

                flag = false
            }
        }

        if (flag) {
            break
        }
    }

    return this
}

fun Array<Int>.sortByQuick(low: Int = 0, high: Int = this.size - 1): Array<Int> {
    if (this.size <= 1) return this

    if (low < high) {
        val p = this.partition(low, high)
        this.sortByQuick(low, p - 1)
        this.sortByQuick(p + 1, high)
    }
    return this
}

private fun Array<Int>.partition(l: Int, h: Int): Int {
    var low = l
    var high = h

    // 基准值
    val pivot = this[low]
    while (low < high) {
        while (low < high && this[high] >= pivot) high--
        var temp = this[high]
        this[high] = this[low]
        this[low] = temp

        while (low < high && this[low] <= pivot) low++
        temp = this[high]
        this[high] = this[low]
        this[low] = temp
    }

    return low
}

fun Array<Int>?.sortByMerge(): Array<Int> {
    if (this == null || this.size <= 1) return this ?: emptyArray()

    val middle = floor(this.size / 2.0).toInt()
    return merge(
            this.sliceArray(0 until middle).sortByMerge(),
            this.sliceArray(middle until this.size).sortByMerge()
    )
}

private fun merge(left: Array<Int>, right: Array<Int>): Array<Int> {
    val result = mutableListOf<Int>()

    var i = 0
    var j = 0
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result.add(left[i])
            i++
        } else {
            result.add(right[j])
            j++
        }
    }

    while (i < left.size) result.add(left[i++])
    while (j < right.size) result.add(right[j++])

    return result.toTypedArray()
}


fun Array<Int>?.sortByHeap(): Array<Int> {
    if (this == null || this.size <= 1) return this ?: emptyArray()

    var i = Math.floor(this.size / 2.0).toInt()
    while (i >= 0) {
        this.makeHeap(i--)
    }

    for (j in (this.size - 1 downTo 1)) {
        val temp = this[0]
        this[0] = this[j]
        this[j] = temp

        this.makeHeap(0, j)
    }

    return this
}

private fun Array<Int>.makeHeap(i: Int, len: Int = this.size): Array<Int> {
    val left = 2 * i + 1
    val right = 2 * i + 2
    var largest = i

    if (left < len && this[left] > this[largest]) {
        largest = left
    }

    if (right < len && this[right] > this[largest]) {
        largest = right
    }

    if (largest != i) {
        val temp = this[i]
        this[i] = this[largest]
        this[largest] = temp

        this.makeHeap(largest, len)
    }

    return this
}