package ru.homework;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.homework.support.TestLifecycle;

import java.util.Arrays;
import java.util.stream.Stream;

import static ru.homework.support.TestData.*;
import static ru.homework.support.TestResult.check;

/** Задача 1: один запуск, двадцать повторов и массив случайных параметров. */
class LectureTest extends TestLifecycle {
    @Test
    void isEvenOnce() {
        int n = randomInt(1, 100);
        check("isEven", String.valueOf(n), (n & 1) == 0, BasicJava.isEven(n));
    }

    @RepeatedTest(20)
    void checkAccessTwentyTimes() {
        int age = randomInt(0, 99);
        check("checkAccess", String.valueOf(age), age >= 19 ? "Allowed" : "Denied",
                BasicJava.checkAccess(age));
    }

    @ParameterizedTest(name = "getGrade: score={0}")
    @MethodSource("randomScores")
    void getGradeWithRandomArray(int score) {
        check("getGrade", String.valueOf(score), expectedGrade(score), BasicJava.getGrade(score));
    }

    static Stream<Integer> randomScores() {
        int[] scores = randomNumbers(10, 0, 100);
        return Arrays.stream(scores).boxed();
    }
}
