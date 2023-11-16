package io.patamon.todo.common

import java.util.ArrayDeque

/**
 * Desc: 树节点
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-01-05
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(`val`: Int, left: Int?) : this(`val`) {
        if (left != null) {
            this.left = TreeNode(left)
        }
    }

    constructor(`val`: Int, left: Int?, right: Int?) : this(`val`) {
        if (left != null) {
            this.left = TreeNode(left)
        }
        if (right != null) {
            this.right = TreeNode(right)
        }
    }

    fun left(v: Int): TreeNode {
        this.left = TreeNode(v)
        return this
    }

    fun left(n: TreeNode): TreeNode {
        this.left = n
        return this
    }

    fun right(v: Int): TreeNode {
        this.right = TreeNode(v)
        return this
    }

    fun right(n: TreeNode): TreeNode {
        this.right = n
        return this
    }

    fun levelOrder(): List<List<Int>> {
        val nodes = mutableListOf<MutableList<Int>>()

        val queue = ArrayDeque<Pair<Int, TreeNode?>>()
        queue.offer(0 to this)
        while(queue.isNotEmpty()) {
            val (index, node) = queue.poll()
            if (node != null) {
                if (nodes.size <= index) {
                    nodes.add(mutableListOf())
                }
                nodes[index].add(node.`val`)

                // 入队列
                queue.offer(index + 1 to node.left)
                queue.offer(index + 1 to node.right)
            }
        }
        return nodes
    }
}
