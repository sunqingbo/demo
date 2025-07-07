package com.demo.myapplication

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalTime
import kotlin.test.assertEquals

class MyGreeterTest {

    companion object {
        // 提供测试数据
        @JvmStatic
        fun provideTestData(): List<Arguments> {
            return listOf(
                Arguments.of(LocalTime.of(9, 0), "Good morning", "测试早晨时间"),
                Arguments.of(LocalTime.of(15, 0), "Good afternoon", "测试下午时间"),
                Arguments.of(LocalTime.of(20, 0), "Good evening", "测试晚上时间"),
                Arguments.of(LocalTime.of(6, 0), "Good evening", "测试边界时间 6:00"),
                Arguments.of(LocalTime.of(12, 0), "Good evening", "测试边界时间 12:00"),
                Arguments.of(LocalTime.of(18, 0), "Good evening", "测试边界时间 18:00")
            )
        }
    }

    // 参数化测试方法
    @ParameterizedTest
    @MethodSource("provideTestData")
    @DisplayName("测试不同时间的问候语")
    fun testGreeting(time: LocalTime, expectedGreeting: String, testDescription: String) {
        val greeter = MyGreeter(time)
        assertEquals(expectedGreeting, greeter.greeting(), testDescription)
    }
}