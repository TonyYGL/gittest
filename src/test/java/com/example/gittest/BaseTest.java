package com.example.gittest;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTest {

    @RepeatedTest(10)
    public void testRepeat(RepetitionInfo repetitionInfo) {
        System.out.println("repetitionInfo = " + repetitionInfo);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Bob", "Josh", "Tony"})
    public void testParameterizeTest(String student) {
        System.out.println("student = " + student);
    }
}
