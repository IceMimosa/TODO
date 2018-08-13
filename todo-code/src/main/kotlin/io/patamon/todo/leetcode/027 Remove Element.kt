package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 27. Remove Element
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 *
 * ```
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * ```
 *
 * Example 2:
 *
 * ```
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 * ```
 *
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 *
 * ```
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);

 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * ```
 *
 * =============================================================================================================
 *
 * # 27. 移除元素
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class RemoveElement : StringSpec({

    /**
     * [removeDuplicates]
     */
    "双指针法" {
        intArrayOf(3, 2, 2, 3).removeElement(3) shouldBe 2
        intArrayOf(0, 1, 2, 2, 3, 0, 4, 2).removeElement(2) shouldBe 5
        intArrayOf(0, 0, 0).removeElement(0) shouldBe 0
        intArrayOf(0, 1, 2).removeElement(3) shouldBe 3

        intArrayOf(3, 2, 2, 3).removeElement2(3) shouldBe 2
        intArrayOf(0, 1, 2, 2, 3, 0, 4, 2).removeElement2(2) shouldBe 5
        intArrayOf(0, 0, 0).removeElement2(0) shouldBe 0
        intArrayOf(0, 1, 2).removeElement2(3) shouldBe 3
    }

})


/**
 *  1. 第一想法就是找到一个(一批)重复的, 就从后往前移动数组, 删掉那个重复的
 *
 *  分析:
 *      这样需要不断地移动数组, 不是最佳方案
 */
// 略...

/**
 * 2. 类似 [RemoveDuplicatesFromSortedArray] 的双指针解法
 *
 * 时间复杂度: O(n)
 *   分析: pos 和 this 都在移动, 最坏情况(元素都不等于[element]), 则需要移动2n步
 *
 * 空间复杂度: O(1)
 */
private fun IntArray.removeElement(element: Int): Int {
    if (this.isEmpty()) return 0

    var pos = 0
    for (num in this) {
        if (num != element) {
            // 可以判断 pos 是否等于当前 index
            this[pos++] = num
        }
    }
    return pos
}

/**
 * 3. 双指针法优化, 让双指针移动更少的步数
 *
 * 时间复杂度: O(n)
 *     分析: pos 从头移动, last 从尾部移动, 这样移动次数最多为n
 *     缺陷: 数组中元素的顺序被打乱了
 *
 * 空间复杂度: O(1)
 */
private fun IntArray.removeElement2(element: Int): Int {
    if (this.isEmpty()) return 0

    var pos = 0
    var last = this.size - 1
    while (pos <= last) {
        if (this[pos] == element) {
            this[pos] = this[last]
            last--
        } else {
            pos++
        }
    }
    return last + 1
}

