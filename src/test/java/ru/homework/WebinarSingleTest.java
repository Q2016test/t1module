package ru.homework;

import org.junit.jupiter.api.Test;
import ru.homework.support.TestLifecycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ru.homework.support.TestData.*;
import static ru.homework.support.TestResult.check;

/** Задача 2: четыре метода с @Test. */
class WebinarSingleTest extends TestLifecycle {
    @Test
    void isEven() {
        for (String[] row : csvRows("/basics.csv", 3)) {
            int value = Integer.parseInt(row[0]);
            check("isEven", row[0], Boolean.parseBoolean(row[1]), BasicJava.isEven(value));
        }
        int n = randomInt(-1000, 1000);
        check("isEven", String.valueOf(n), (n & 1) == 0, BasicJava.isEven(n));
    }

    @Test
    void isPositive() {
        for (String[] row : csvRows("/basics.csv", 3)) {
            int value = Integer.parseInt(row[0]);
            check("isPositive", row[0], Boolean.parseBoolean(row[2]), BasicJava.isPositive(value));
        }
        int n = randomInt(-1000, 1000);
        check("isPositive", String.valueOf(n), Integer.signum(n) != -1, BasicJava.isPositive(n));
    }

    @Test
    void hasBug() {
        String[] messages = randomMessages();
        boolean expected = Arrays.stream(messages).anyMatch("bug"::equalsIgnoreCase);
        check("hasBug", Arrays.toString(messages), expected, BasicJava.hasBug(messages));
    }

    @Test
    void reverse() {
        String[] input = randomNames();
        String[] snapshot = input.clone();
        List<String> expected = new ArrayList<>(Arrays.asList(input));
        Collections.reverse(expected);
        String[] actual = BasicJava.reverse(input);
        check("reverse", Arrays.toString(input), expected.toArray(new String[0]), actual);
        check("reverse preserves input", Arrays.toString(snapshot), snapshot, input);
        check("reverse returns new array", Arrays.toString(input), true, actual != input);
    }
}
