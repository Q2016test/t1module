package ru.homework.support;

import java.util.Arrays;
import java.util.Objects;

/** Сравнение с эталоном через if, без assert и JUnit Assertions. */
public final class TestResult {
    private TestResult() {
    }

    public static void check(String method, String input, Object expected, Object actual) {
        System.out.printf("%s(%s): expected=%s, actual=%s%n",
                method, input, display(expected), display(actual));
        if (Objects.deepEquals(expected, actual)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            // Ошибка также делает результат JUnit и Gradle неуспешным.
            throw new IllegalStateException(method + ": expected=" + display(expected) + ", actual=" + display(actual));
        }
    }

    private static String display(Object value) {
        return value instanceof Object[] ? Arrays.deepToString((Object[]) value) : String.valueOf(value);
    }
}
