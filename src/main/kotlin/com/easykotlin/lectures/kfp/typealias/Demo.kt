package com.easykotlin.lectures.kfp.`typealias`

fun isOdd(x: Int) = x % 2 != 0
fun length(s: String) = s.length

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun main(args: Array<String>) {
    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength)) // [a, abc]

    val fg = fg(isOdd, stringLength)
    println(strings.filter(fg))
}

typealias MyStringFun<T> = (s: String) -> T
typealias MyIntFun<K> = (i: Int) -> K

val stringLength: MyStringFun<Int> = { it.length }
val isOdd: MyIntFun<Boolean> = { it % 2 == 1 }


typealias A = String
typealias B = Int
typealias C = Boolean

typealias X = (A) -> B
typealias Y = (B) -> C
typealias Z = (A) -> C

fun fg(f: Y, g: X): Z {
    return { x -> f(g(x)) }
}


val map0: MutableMap<String, List<Map<Int, List<String>>>> = hashMapOf()







typealias MyMMMap = MutableMap<String, List<Map<Int, List<String>>>>



val map1: MyMMMap = hashMapOf()
