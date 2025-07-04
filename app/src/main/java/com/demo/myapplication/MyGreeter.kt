package com.demo.myapplication

import java.time.LocalTime

// 定义 MyGreeter 类，
class MyGreeter {
    fun greeting(): String {
        // 获取当前时间
        val currentTime = LocalTime.now()
        return when {
            // 早晨6-12点返回 "早晨"
            currentTime.isAfter(LocalTime.of(6, 0)) && currentTime.isBefore(LocalTime.of(12, 0)) -> "Good morning"
            // 下午12-6点返回 "下午"
            currentTime.isAfter(LocalTime.of(12, 0)) && currentTime.isBefore(LocalTime.of(18, 0)) -> "Good afternoon"
            // 晚上6-第二天6点返回 "晚上"
            else -> "Good evening"
        }
    }
}
