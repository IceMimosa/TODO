package io.patamon.todo.common

/**
 * Desc: 简单链表节点
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2018/8/9
 */
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null

    companion object {

        /**
         * 生成节点方法
         */
        @JvmStatic
        fun makeNodes(vararg args: Int): ListNode? {
            val out = ListNode(0)
            var curr = out
            args.forEach {
                curr.next = ListNode(it)
                curr = curr.next!!
            }
            return out.next
        }

        @JvmStatic
        fun makeNodes(vararg args: ListNode): ListNode? {
            val out = ListNode(0)
            var curr = out
            args.forEach {
                curr.next = it
                curr = curr.next!!
            }
            return out.next
        }
    }

    /**
     * 获取节点中所有的val值
     */
    fun getAllValues(): MutableList<Int>? {
        val args = mutableListOf<Int>()
        var curr: ListNode? = this
        while (curr != null) {
            args.add(curr.`val`)
            curr = curr.next
        }
        return args
    }
}