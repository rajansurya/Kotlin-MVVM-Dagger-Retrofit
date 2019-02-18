package com.thread.test

import java.util.*

class SharedOb {
    fun test1(sh2: SharedOb) {
        println("test1 start")
        Thread.sleep(1000)
        sh2.test2(this)
        println("test1 end")
    }

    fun test2(sh1: SharedOb) {
        println("test2 start")
        Thread.sleep(1000)
        sh1.test1(this)
        println("test2 end")
    }
}

class Thread1 constructor(var sh1: SharedOb, var sh2: SharedOb) : Thread() {
    override fun run() {
        super.run()
        sh1.test1(sh2)
    }

}

class Thread2 constructor(var sh1: SharedOb, var sh2: SharedOb) : Thread() {
    override fun run() {
        super.run()
        sh2.test2(sh1)
    }

}

class CallDeadLock {
    fun main(ar: Array<String>) {
        var sh1: SharedOb = SharedOb()
        var sh2: SharedOb = SharedOb()
        var th1L: Thread1 = Thread1(sh1, sh2)
        var th2L: Thread2 = Thread2(sh1, sh2)
        th1L.start()
        th2L.start()
        Thread.sleep(1000)

        var deque: Deque<String> = LinkedList<String>()

    }
}



