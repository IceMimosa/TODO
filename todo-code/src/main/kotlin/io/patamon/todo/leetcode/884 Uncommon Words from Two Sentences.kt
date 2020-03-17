package io.patamon.todo.leetcode

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * Desc:
 *
 * # 884. Uncommon Words from Two Sentences(两句话中的不常见单词)
 *
 *  给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 *
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * 返回所有不常用单词的列表。
 * 您可以按任何顺序返回列表。
 *
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2020-03-01
 */


class UncommonWordsFromTwoSentences: StringSpec({

    "Uncommon Words from Two Sentences" {
        "this apple is sweet".uncommonFromSentences("this apple is sour") shouldBe arrayOf("sweet", "sour")
        "apple apple".uncommonFromSentences("banana") shouldBe arrayOf("banana")
    }

})

private fun String?.uncommonFromSentences(b: String): Array<String> {
    this ?: return emptyArray()
    return ("$this $b").split(" ")
            .groupingBy { k -> k }.eachCount()
            .filter { it.value == 1 }
            .keys
            .toTypedArray()
}
