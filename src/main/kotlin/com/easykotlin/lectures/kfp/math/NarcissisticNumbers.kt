package com.easykotlin.lectures.kfp.math

import java.math.BigInteger

class NarcissisticNumbers {
    val TEN = BigInteger.TEN

    /**
     *
     * 获取一个 n 位数 N 的各个位上的数字，放到一个 List 中：
     * N=153, digits=[1,5,3]
     */
    fun digits(N: BigInteger, n: Int): ArrayList<Int> {
        var M = N
        var digits = arrayListOf<Int>()

        (1..n).forEach {
            val remainder = M.mod(TEN)
            digits.add(remainder.intValueExact())
            M = M.divide(TEN)
        }
        digits.reverse()
        return digits
    }

    /**
     *  数字 0-9 的 n次幂
     *  0, 1, 2^n, 3^n,...,9^n
     */
    fun zero2NinePower(n: Int): List<BigInteger> {
        var result = arrayListOf<BigInteger>()
        result.add(BigInteger.ZERO)
        result.add(BigInteger.ONE)
        (2..9).forEach {
            result.add(BigInteger.valueOf(it.toLong()).pow(n))
        }
        return result
    }

    fun checkOut(n: Int) {
        var N_ = BigInteger.ZERO
        val zero2NinePowers = zero2NinePower(n)
        // d0 表示0出现次数，d1 表示1出现次数。例如： 数字153，有 d0=1,d1=1,d2=0,d3=1,d4=0,d5=1,...
        for (d0 in 0L..(n - 1)) {
            for (d1 in 0L..(n - d0)) {
                for (d2 in 0L..(n - d0 - d1)) {
                    for (d3 in 0L..(n - d0 - d1 - d2)) {
                        for (d4 in 0L..(n - d0 - d1 - d2 - d3)) {
                            for (d5 in 0L..(n - d0 - d1 - d2 - d3 - d4)) {
                                for (d6 in 0L..(n - d0 - d1 - d2 - d3 - d4 - d5)) {
                                    for (d7 in 0L..(n - d0 - d1 - d2 - d3 - d4 - d5 - d6)) {
                                        for (d8 in 0L..(n - d0 - d1 - d2 - d3 - d4 - d5 - d6 - d7)) {
                                            for (d9 in 0L..(n - d0 - d1 - d2 - d3 - d4 - d5 - d6 - d7 - d8)) {
                                                N_ = zero2NinePowers[0].multiply(BigInteger.valueOf(d0)) +
                                                        zero2NinePowers[1].multiply(BigInteger.valueOf(d1)) +
                                                        zero2NinePowers[2].multiply(BigInteger.valueOf(d2)) +
                                                        zero2NinePowers[3].multiply(BigInteger.valueOf(d3)) +
                                                        zero2NinePowers[4].multiply(BigInteger.valueOf(d4)) +
                                                        zero2NinePowers[5].multiply(BigInteger.valueOf(d5)) +
                                                        zero2NinePowers[6].multiply(BigInteger.valueOf(d6)) +
                                                        zero2NinePowers[7].multiply(BigInteger.valueOf(d7)) +
                                                        zero2NinePowers[8].multiply(BigInteger.valueOf(d8)) +
                                                        zero2NinePowers[9].multiply(BigInteger.valueOf(d9))
                                                doCheck(N_, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, n)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun doCheck(N_: BigInteger, d0: Long, d1: Long, d2: Long, d3: Long, d4: Long, d5: Long, d6: Long, d7: Long, d8: Long, d9: Long, n: Int) {
        // 数字 N_ 每位上的数字，例如： N_ = 153，  digitCounts = [1,5,3]
        val digitCounts = digits(N_, n)
        // 统计 digitCounts 中 0-9 分别出现的次数
        val d_ = arrayListOf(0L, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        digitCounts.forEach {
            when (it) {
                0 -> d_[0]++
                1 -> d_[1]++
                2 -> d_[2]++
                3 -> d_[3]++
                4 -> d_[4]++
                5 -> d_[5]++
                6 -> d_[6]++
                7 -> d_[7]++
                8 -> d_[8]++
                9 -> d_[9]++
            }
        }
        var sum = 0
        d_.forEach { sum += it.toInt() }
        if (d0 == d_[0] &&
                d1 == d_[1] &&
                d2 == d_[2] &&
                d3 == d_[3] &&
                d4 == d_[4] &&
                d5 == d_[5] &&
                d6 == d_[6] &&
                d7 == d_[7] &&
                d8 == d_[8] &&
                d9 == d_[9] &&
                sum == n && validateBitWidth(N_, n)) { // 完全数字不变数
            println("${N_}")
//            println("d_ = ${d_}")
//            println("digitCounts = ${digitCounts}")
        }
    }

    /** 过滤掉，N 首位是 0 的情况：
     * 类似 : 5 位数：
    这样的数称为完全数字不变数（perfect digital invariant）
    N_ = 4151
    d_ = [1, 2, 0, 0, 1, 1, 0, 0, 0, 0]
    digitCounts = [0, 4, 1, 5, 1]
    5 位数：
    N_ = 4150
    d_ = [2, 1, 0, 0, 1, 1, 0, 0, 0, 0]
    digitCounts = [0, 4, 1, 5, 0]
    5 位数：
    N_ = 1
    d_ = [4, 1, 0, 0, 0, 0, 0, 0, 0, 0]
    digitCounts = [0, 0, 0, 0, 1]
     */
    fun validateBitWidth(N_: BigInteger, n: Int): Boolean {
        var count = 0
        var N = N_
        while (N > BigInteger.ZERO) {
            N = N.divide(BigInteger.TEN)
            count++
        }
//        println("count=$count")
        return n == count
    }

}