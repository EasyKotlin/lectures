package com.easykotlin.lectures.kfp.math

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.math.BigInteger

@RunWith(JUnit4::class)
class NarcissisticNumbersTest {
    val NarcissisticNumbers = NarcissisticNumbers()

    @Test
    fun test_digits() {
        println(NarcissisticNumbers.digits(BigInteger.valueOf(153), 3))
        println(NarcissisticNumbers.digits(BigInteger.valueOf(1634), 4))
        println(NarcissisticNumbers.digits(BigInteger.valueOf(4150), 4))
    }

    @Test
    fun test_zero2NinePower() {
        println(NarcissisticNumbers.zero2NinePower(3))
        println(NarcissisticNumbers.zero2NinePower(4))
        println(NarcissisticNumbers.zero2NinePower(21))
    }

    @Test
    fun test_validateBitWidth() {
        println(NarcissisticNumbers.validateBitWidth(BigInteger.valueOf(4151), 5))
    }

    @Test
    fun test_checkOut() {
        (1..39).forEach {
            println("-----------------------------")
            println("$it 位水仙花数：")
            val s = System.currentTimeMillis()
            NarcissisticNumbers.checkOut(it)
            val t = System.currentTimeMillis()
            println("时间：${t - s} ms")
        }
    }
}