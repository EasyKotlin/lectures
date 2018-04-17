package com.easykotlin.lectures.kfp

fun main(args: Array<String>) {
    test1()
    test2()
    test3()

//    9801
//    25
//    50

}

fun test3() {
    val f = { x: Int, y: Int, z: Int -> x * x + y * y + z * z }
    val y = f(3, 4, 5)
    println(y)
}

fun test2() {
    val f = { x: Int, y: Int -> x * x + y * y }
    val y = f(3, 4)
    println(y)
}

fun test1() {
    val f = { x: Int -> x * x }
    val y = f(99)
    println(y)
}

