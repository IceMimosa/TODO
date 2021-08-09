package io.patamon.todo.common

import io.kotest.core.spec.style.StringSpec

/**
 * Mail: chk19940609@gmail.com
 * Created by IceMimosa
 * Date: 2021/8/10
 */
abstract class BaseSpec(func: StringSpec.() -> Unit) : StringSpec(func) {

    init {
        beforeSpec {  }

        afterSpec { }
    }
}