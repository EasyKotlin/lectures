package com.easykotlin.lectures.kfp.math

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProofTest {
    val Propositions = Propositions()
    val PrimeNumer = PrimeNumer()

    /**
     * 素数判定
     */
    @Test
    fun test1() {
        var i = 1L
        while (i < 10000L) {
            val f1 = Propositions.f1(i)
            println(f1)
            if (!PrimeNumer.isPrime(f1)) {
                println("n=$i f1(n)=$f1 IS NOT A PRIME NUMBER.")
                break
            }
            i++
        }
    }

    /**
     * 穷举算法
     */
    @Test
    fun test2() {
        val start = System.currentTimeMillis()
        var count = 0
        val MAX = 200
        // 计算量很大
        var a = 1L
        loop@ while (a < MAX) {
            var b = 1L
            while (b < MAX) {
                var c = 1L
                while (c < MAX) {
                    var d = 1L
                    while (d < MAX) {
                        var e = 1L
                        while (e < MAX) {
                            if (e > a && e > b && e > c && e > d) {
                                val f2 = Propositions.f2(a, b, c, d, e)
                                println("[${count++}] ($a,$b,$c,$d,$e) -> ($f2) | ")
                                if (f2 == 0L) {
                                    println("[a,b,c,d,e]=[$a,$b,$c,$d,$e] IS A SOLUTION OF Euler's Conjecture: a^5+b^5+c^5+d^5=e^5")
                                    break@loop
                                }
                            }
                            e++
                        }
                        d++
                    }
                    c++
                }
                b++
            }
            a++
        }

        val end = System.currentTimeMillis()
        println("Using Time: ${(end - start) / 1000} s")
    }


    @Test
    fun test3() {
        var list1 = arrayListOf<Pair<Long, String>>()
        var list2 = arrayListOf<Pair<Long, String>>()

        val start1 = System.currentTimeMillis()
        // 假设： a<b<c<d, 肯定有： e > {a,b,c,d}
        for (a in 1..200L) {
            for (b in a..200L) {
                for (c in b..200L) {
                    Propositions.f3(a, b, c)
                    list1.add(Pair(Propositions.f3(a, b, c), "a=$a,b=$b,c=$c"))
                }
            }
        }
        val end1 = System.currentTimeMillis()
        println("Using Time1: ${(end1 - start1)} ms")
        println("list1.size=${list1.size}")

        val start2 = System.currentTimeMillis()
        for (d in 1..200L) {
            (d..200L).mapTo(list2) { Pair(Propositions.f4(it, d), "e=$it,d=$d") }
        }
        val end2 = System.currentTimeMillis()
        println("Using Time2: ${(end2 - start2)} ms")
        println("list2.size=${list2.size}")

        /*
        首先想到的，遍历所有元素，穷举判断；更进一层：平均切割 List，每一段开启1个线程计算。
        val start3 = System.currentTimeMillis()
        loop@ for (x in list2) {
            if (list1.contains(x)) {
                println("x=$x")
                break@loop
            }
        }
        val end3 = System.currentTimeMillis()
        println("Using Time3: ${(end3 - start3)} ms")
        */

        val start3 = System.currentTimeMillis()
        var list1n = arrayListOf<List<Pair<Long, String>>>()
        val segment = 10_0000
        val step = list1.size / segment
        for (i in 1..segment) {
            var listi = arrayListOf<Pair<Long, String>>()
            for (j in ((i - 1) * step)..(i * step - 1)) {
                listi.add(list1[j])
            }
            list1n.add(listi)
        }
        println("list1n.size=${list1n.size}")
        val end3 = System.currentTimeMillis()
        println("Using Time3: ${(end3 - start3)} ms")

        val start4 = System.currentTimeMillis()
        var threadList = arrayListOf<Thread>()
        list1n.forEach {
            threadList.add(Thread {
                for (x in list2) {
                    it.filter { x.first == it.first }
                            .forEach { println("$x,$it") }
                }
            })
        }
        println("threadList.size=${threadList.size}")
        for (thread in threadList) {
            thread.start()
            thread.join()
        }
        val end4 = System.currentTimeMillis()
        println("Using Time4: ${(end4 - start4)} ms")
    }

}