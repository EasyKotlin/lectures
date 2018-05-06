package com.easykotlin.lectures.kfp.math

class Propositions {

    fun f1(n: Long): Long {
        return n * n + n + 41
    }

    /**
     * Euler's Conjecture : f2(a,b,c,d)=0 has no solution, when a,b,c,d > 0
     */
    fun f2(a: Long, b: Long, c: Long, d: Long, e: Long): Long {
        return a * a * a * a * a +
                b * b * b * b * b +
                c * c * c * c * c +
                d * d * d * d * d -
                e * e * e * e * e
    }

    fun f3(a: Long, b: Long, c: Long): Long {
        return a * a * a * a * a +
                b * b * b * b * b +
                c * c * c * c * c
    }

    fun f4(e: Long, d: Long): Long {
        return e * e * e * e * e - d * d * d * d * d
    }

}