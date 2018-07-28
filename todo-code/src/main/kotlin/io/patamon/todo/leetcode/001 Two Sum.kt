package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * ```
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ```
 * =============================================================================================================
 *
 * # 1. 两数之和
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * ```
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * ```
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/7/26
 */
class TwoSum : StringSpec({

    /**
     * 暴力法: [findTwoSumIndexes]
     */
    "暴力法 测试" {
        intArrayOf(2, 7, 11, 15).findTwoSumIndexes(target = 9) shouldBe intArrayOf(0, 1)
        intArrayOf(3, 2, 4).findTwoSumIndexes(target = 6) shouldBe intArrayOf(1, 2)
    }

    /**
     * 两遍哈希表: [findTwoSumIndexesWithMapTwoStep]
     */
    "两遍哈希表 测试" {
        intArrayOf(2, 7, 11, 15).findTwoSumIndexesWithMapTwoStep(target = 9) shouldBe intArrayOf(0, 1)
        intArrayOf(3, 2, 4).findTwoSumIndexesWithMapTwoStep(target = 6) shouldBe intArrayOf(1, 2)
    }

    /**
     * 一遍哈希表: [findTwoSumIndexesWithMapOneStep]
     */
    "一遍哈希表 测试" {
        intArrayOf(2, 7, 11, 15).findTwoSumIndexesWithMapOneStep(target = 9) shouldBe intArrayOf(0, 1)
        intArrayOf(3, 2, 4).findTwoSumIndexesWithMapOneStep(target = 6) shouldBe intArrayOf(1, 2)
    }

})

/**
 * 暴力法: 遍历数组, 找出满足target的两个数
 *
 * 时间复杂度: O(n²)
 * 空间复杂度: O(1)
 */
private fun IntArray.findTwoSumIndexes(target: Int): IntArray {
    for (i in 0 until this.count()) {
        for (j in i + 1 until this.count()) {
            if (this[i] + this[j] == target) { // 或者 this[i] == target - this[j]
                return intArrayOf(i, j)
            }
        }
    }
    throw IllegalArgumentException("No two sum solution")
}


/**
 * 两遍哈希表
 *
 * 时间复杂度: O(n) + O(n) ≈ O(n)
 * 空间复杂度: O(n)
 */
private fun IntArray.findTwoSumIndexesWithMapTwoStep(target: Int): IntArray {
    // 1. 定义一个map, 存num -> index
    val maps = mutableMapOf<Int, Int>()
    this.forEachIndexed { i, num -> maps[num] = i }

    // 2. 遍历数组
    for (i in 0 until this.count()) {
        val second = target - this[i]
        // maps 中存在 second, 并且 second 的下标和当前不一样
        if (maps.containsKey(second) && i != maps[second]) {
            return intArrayOf(i, maps[second]!!)
        }
    }
    throw IllegalArgumentException("No two sum solution")
}

/**
 * 一遍哈希表, 对上述两遍哈希表的进行优化
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
private fun IntArray.findTwoSumIndexesWithMapOneStep(target: Int): IntArray {
    // 1. 定义一个map, 存num -> index
    val maps = mutableMapOf<Int, Int>()

    // 2. 遍历数组
    for (i in 0 until this.count()) {
        val second = target - this[i]
        // maps 中存在 second, 并且 second 的下标和当前不一样
        if (maps.containsKey(second)) {
            return intArrayOf(maps[second]!!, i) // 注意返回顺序
        }

        // 放入map中
        maps[this[i]] = i
    }
    throw IllegalArgumentException("No two sum solution")
}

