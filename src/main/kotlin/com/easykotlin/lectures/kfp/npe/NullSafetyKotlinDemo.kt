package com.easykotlin.lectures.kfp.npe

import java.util.*

fun main(args: Array<String>) {
    val demo = NullSafetyKotlinDemo()
    demo.test1()
    val demo2 = NullSafetyNonNullableTypeDemo()
    demo2.test2()
}

class NullSafetyKotlinDemo {

    fun test1() {
        try {
            // object is null
            val nullMilestone: Milestone? = null
            val flag = check1(nullMilestone)
            if (flag) {
                println("A检查通过")
            } else {
                println("A检查不通过")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            // field is null
            val milestone = Milestone()
            milestone.name = "发布上线"
            val flag = check1(milestone)
            if (flag) {
                println("B检查通过")
            } else {
                println("B检查不通过")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun check1(milestone: Milestone?): Boolean {
        val b1 = milestone?.finishTime?.before(Date())
        val b2 = milestone?.state == 1
        if (null == b1) return false;
        return b1 && b2
    }

    class Milestone {
        var name: String? = null
        var finishTime: Date? = null
        var state: Int? = null
    }

}


class NullSafetyNonNullableTypeDemo {

    fun test2() {
        val nullMilestone: Milestone? = null
//      val flag1 = check2(nullMilestone) // 编译时直接提示 NPE 错误
        val milestone = Milestone()
        milestone.name = "发布上线"
        val flag2 = check2(milestone)
        if (flag2) {
            println("C检查通过")
        } else {
            println("C检查不通过")
        }
    }

    fun check2(milestone: Milestone): Boolean {
        val b1 = milestone.finishTime.before(Date())
        val b2 = milestone.state == 1
        return b1 && b2
    }

    class Milestone {
        var name: String = ""
        var finishTime: Date = Date(1900, 1 - 1, 1)
        var state: Int = -1
    }
}



