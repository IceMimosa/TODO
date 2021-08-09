package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * Desc:
 *
 * ============================================================================================================
 *
 * # 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * ```
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * ```
 *
 * Example 2:
 *
 * ```
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
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
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * ```
 *
 * =============================================================================================================
 *
 * # 26. 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 *
 * ```
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * ```
 *
 * =============================================================================================================
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/08/10
 */
class RemoveDuplicatesFromSortedArray : StringSpec({

    /**
     * [removeDuplicates]
     */
    "双指针法" {
        intArrayOf(1, 1, 2).removeDuplicates() shouldBe 2
        intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4).removeDuplicates() shouldBe 5

        intArrayOf(1, 1, 2).removeDuplicates2() shouldBe 2
        intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4).removeDuplicates2() shouldBe 5
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
 * 2. 使用两个变量, 一个记住有效元素位置, 一个用来扫描元素. 且题目也说了, 你不用考虑新长度后面的元素
 *
 * 双指针法: 使用慢指针和快指针
 */
private fun IntArray.removeDuplicates(): Int {
    if (this.isEmpty()) return 0

    var i = 0
    var j = 0
    while (j < this.size) {
        // 如果两个数不相等, i++, 然后将j的元素赋值给i
        if (this[i] != this[j]) {
            i++
            // 优化: 可以判断 if (i != j)
            if (i != j) this[i] = this[j]
        }
        // 否则j一直往后扫描
        j++
    }
    return i + 1
}

/**
 * 相同的思想, 改变下代码
 */
private fun IntArray.removeDuplicates2(): Int {
    if (this.isEmpty()) return 0
    var pos = 0
    for (num in this) {
        // 可以判断 ++pos 是否等于当前 index
        if (this[pos] != num) this[++pos] = num
    }
    return pos + 1
}
