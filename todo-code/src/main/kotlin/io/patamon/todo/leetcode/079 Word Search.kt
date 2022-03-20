package io.patamon.todo.leetcode

import io.kotest.matchers.shouldBe
import io.patamon.todo.common.BaseSpec

/**
 * 079. Word Search（单词搜索）
 *
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * * 示例1
 *
 * ```
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * ```
 *
 * * 示例2
 *
 * ```
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * ```
 */
class WordSearch : BaseSpec({

    "Word Search" {
        arrayOf(
            "ABCE".toCharArray(),
            "SFCS".toCharArray(),
            "ADEE".toCharArray()
        ).offset("ABCCED") shouldBe Pair(0, 0)
        arrayOf(
            "ABCE".toCharArray(),
            "SFCS".toCharArray(),
            "ADEE".toCharArray()
        ).offset("SEE") shouldBe Pair(1, 3)
        arrayOf(
            "ABCE".toCharArray(),
            "SFCS".toCharArray(),
            "ADEE".toCharArray()
        ).offset("ABCB") shouldBe Pair(-1, -1)
        arrayOf(
            "AB".toCharArray(),
            "CD".toCharArray()
        ).offset("ACDB") shouldBe Pair(0, 0)
        arrayOf(
            "ABCE".toCharArray(),
            "SFES".toCharArray(),
            "ADEE".toCharArray()
        ).offset("ABCESEEEFS") shouldBe Pair(0, 0)
    }
})

private fun Array<CharArray>.offset(target: String): Pair<Int, Int> {
    if (this.isEmpty() || target.isBlank()) return -1 to -1
    val result = mutableListOf<Pair<Int, Int>>()
    this.forEachIndexed { i, s ->
        s.forEachIndexed { j, c ->
            if (c == target[0]) {
                this.walk(i, j, target, 0, Array(this.size) { Array(s.size) { 0 } }, result)
                if (result.size == target.length) return result.first()
                result.clear()
            }
        }
    }
    return result.firstOrNull() ?: (-1 to -1)
}

// dfs
private fun Array<CharArray>.walk(
    i: Int,
    j: Int,
    target: String,
    find: Int,
    visited: Array<Array<Int>>,
    result: MutableList<Pair<Int, Int>>
) {
    if (i < 0 || j < 0 || i >= this.size || j >= this[0].size) return
    if (find >= target.length || result.size == target.length) return
    if (visited[i][j] == 1) return

    var f = find
    if (target[f] == this[i][j]) {
        val point = i to j
        result.add(point)
        f++

        visited[i][j] = 1
        this.walk(i, j - 1, target, f, visited, result)
        this.walk(i, j + 1, target, f, visited, result)
        this.walk(i - 1, j, target, f, visited, result)
        this.walk(i + 1, j, target, f, visited, result)
        visited[i][j] = 0
        if (result.size != target.length) result.remove(point)
    }
}
