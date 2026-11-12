package ru.homework;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import ru.homework.support.TestLifecycle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ru.homework.support.TestData.*;
import static ru.homework.support.TestResult.check;

/** Задача 2: четыре метода с @RepeatedTest, каждый выполняется 20 раз. */
class WebinarRepeatedTest extends TestLifecycle {
    @RepeatedTest(20)
    void checkAccess(RepetitionInfo repetition) {
        List<String[]> boundaries = csvRows("/access.csv", 2);
        int index = repetition.getCurrentRepetition() - 1;
        if (index < boundaries.size()) {
            String[] row = boundaries.get(index);
            check("checkAccess", row[0], row[1], BasicJava.checkAccess(Integer.parseInt(row[0])));
        } else {
            int age = randomInt(0, 99);
            check("checkAccess", String.valueOf(age), age >= 19 ? "Allowed" : "Denied",
                    BasicJava.checkAccess(age));
        }
    }

    @RepeatedTest(20)
    void blastOff() {
        int start = randomInt(-5, 20);
        String countdown = IntStream.range(0, Math.max(0, start))
                .map(i -> start - i).mapToObj(Integer::toString).collect(Collectors.joining(" "));
        String expected = countdown.isEmpty() ? "Поехали!" : countdown + " Поехали!";
        check("blastOff", String.valueOf(start), expected, BasicJava.blastOff(start));
    }

    @RepeatedTest(20)
    void findMax() {
        int[] input = randomNumbers(randomInt(1, 20), -1000, 1000);
        int[] sorted = input.clone();
        Arrays.sort(sorted);
        check("findMax", Arrays.toString(input), sorted[sorted.length - 1], BasicJava.findMax(input));
    }

    @RepeatedTest(20)
    void calcAverage() {
        List<Integer> input = Arrays.stream(randomNumbers(randomInt(0, 20), -1000, 1000))
                .boxed().collect(Collectors.toList());
        double expected = input.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        check("calcAverage", input.toString(), expected, BasicJava.calcAverage(input));
    }
}
