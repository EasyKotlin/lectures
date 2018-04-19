package com.easykotlin.lectures.kfp.extensions

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    //readText()
    val result = "tree".execute();
    println(result)
}

private fun String.execute(): String {
    var result = ""
    val runtime = Runtime.getRuntime()
    val p = runtime.exec(this) // this,指接收者对象(receiver object)(也就是调用扩展函数时, 在"."号之前指定的对象实例)
    val inputStream = p.inputStream
    val inputStreamReader = InputStreamReader(inputStream)
    val bufferedReader = BufferedReader(inputStreamReader)
    var line: String? = ""
    while (line != null) {
        line = bufferedReader.readLine()
        result = "$result$line\n"
    }
    return result
}

fun readText() {
    val f = File("build.gradle")
    println(f.readText())
}