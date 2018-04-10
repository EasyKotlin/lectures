package com.easykotlin.lectures.fp

fun filterOddNums(list: List<Int>): List<Int> {
    return list.filter { it % 2 == 1 }
}

fun filterOddLengthStrings(stringList: List<String>): List<String> {
    return stringList.filter { it.length % 2 == 1 }
}

val f = fun(x: Int) = x % 2 == 1 // 判断输入的 Int 是否奇数
val g = fun(s: String) = s.length // 返回输入的字符

// h = f(g(x))
val h = fun(g: (String) -> Int, f: (Int) -> Boolean): (String) -> Boolean {
    return { f(g(it)) }
}

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5, 6, 7)
    println(filterOddNums(list))

    val stringList = listOf("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg")
    println(filterOddLengthStrings(stringList))

    println(stringList.filter(h(g, f)))
}