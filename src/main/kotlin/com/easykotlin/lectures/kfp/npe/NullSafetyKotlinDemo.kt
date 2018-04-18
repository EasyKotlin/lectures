package com.easykotlin.lectures.kfp.npe

import java.util.*


fun main(args: Array<String>) {
    val demo = NullSafetyKotlinDemo()
    demo.test()
}

class NullSafetyKotlinDemo {

    fun test() {
        val nullMilestone: Milestone? = null
        println(check(nullMilestone))

        val milestone = Milestone()
        milestone.name = "发布上线"
        println(check(milestone))
    }

    fun check(milestone: Milestone?): Boolean {
        val b1 = milestone?.finishTime?.before(Date()) ?: false
        val b2 = milestone?.state == 1
        return b1 && b2
    }

    class Milestone {
        var name: String? = null
        var finishTime: Date? = null
        var state: Int? = null
    }

}


