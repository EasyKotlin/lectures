package com.easykotlin.lectures.kfp.extensions

fun main(args: Array<String>) {
    val list = mutableListOf(1, 2, 3)
    list.swap(1, 2)
    println(list)
}

private fun <E> MutableList<E>.swap(index1: Int, index2: Int) {
    val e1 = this[index1]
    val e2 = this[index2]
    this[index1] = e2
    this[index2] = e1
}


/**
在不修改原类的情况下, Kotlin能给一个类扩展新功能,无需继承该类,也不用任何设计模式(如装饰模式等),
Kotlin支持扩展函数和扩展属性!

为什么要使用扩展(动机): 在Java中,有很多工具类如java.util.Collections,使用很繁琐：
// Java
Collections.swap(list,index1,index2)

静态导入Collections类,简化写法:
// Java
swap(list,index1,index2)

静态导入使用依然很麻烦,如果能给list类添加扩展函数就好了:

list.swap(index1,index2)
 */
