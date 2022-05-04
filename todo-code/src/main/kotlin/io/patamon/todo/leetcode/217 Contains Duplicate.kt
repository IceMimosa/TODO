package io.patamon.todo.leetcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


/**
 *
 * 217. 存在重复元素
 *
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 *
 * 示例3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
class ContainsDuplicate : StringSpec({

    "Contains Duplicate" {
        intArrayOf(1, 2, 3, 1).containsDuplicate() shouldBe true
        intArrayOf(1, 2, 3, 4).containsDuplicate() shouldBe false
        intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2).containsDuplicate() shouldBe true

        intArrayOf(1, 2, 3, 1).containsDuplicateHash() shouldBe true
        intArrayOf(1, 2, 3, 4).containsDuplicateHash() shouldBe false
        intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2).containsDuplicateHash() shouldBe true
    }

})

// 暴力遍历

// sort + iterate
private fun IntArray.containsDuplicate(): Boolean {
    if (this.isEmpty()) return false
    this.sort()
    for (i in 1 until this.size) {
        if (this[i - 1] == this[i]) {
            return true
        }
    }
    return false
}


// hashset
private fun IntArray.containsDuplicateHash(): Boolean {
    val set = hashSetOf<Int>()
    for (n in this) {
        if (!set.add(n)) return true
    }
    return false
}
