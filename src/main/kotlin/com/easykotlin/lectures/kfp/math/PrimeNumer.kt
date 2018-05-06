package com.easykotlin.lectures.kfp.math

class PrimeNumer {

    /**
     * 定理: 如果n不是素数, 则n有满足1< d<=sqrt(n)的一个因子d.

    证明: 如果n不是素数, 则由定义n有一个因子d满足1< d< n.
    如果d大于sqrt(n), 则n/d是满足1< n/d<=sqrt(n)的一个因子.
     */
    fun isPrime(n: Long): Boolean {
        if (n < 2L) return false
        if (n == 2L) return true
        if (n % 2 == 0L) return false
        var i = 3
        while (i * i <= n) {
            if (n % i == 0L) return false
            i += 2
        }
        return true
    }
}