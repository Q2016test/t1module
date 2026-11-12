package ru.homework.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public final class TestData {
    private static final String[] MESSAGES = {"Bug", "BUG", "bUg", "bug", "debug", "OK", "", null};
    private static final String[] NAMES = {"Alex", "Maria", "Ivan", "Alex", "alex", null};

    private TestData() {
    }

    /** Обе границы включены. Используются небольшие диапазоны учебных задач. */
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int[] randomNumbers(int count, int min, int max) {
        return ThreadLocalRandom.current().ints(count, min, max + 1).toArray();
    }

    public static String[] randomMessages() {
        return randomStrings(MESSAGES);
    }

    public static String[] randomNames() {
        return randomStrings(NAMES);
    }

    private static String[] randomStrings(String[] values) {
        return Stream.generate(() -> values[randomInt(0, values.length - 1)])
                .limit(randomInt(0, 12)).toArray(String[]::new);
    }

    /** Эталон по таблице диапазонов, независимо от if/else в BasicJava. */
    public static String expectedGrade(int score) {
        if (score < 0 || score > 100) {
            return "Error";
        }
        String[] grades = {"E", "D", "C", "B", "A"};
        return grades[score == 0 ? 0 : (score - 1) / 20];
    }

    /** Формат простых таблиц: заголовок и ячейки без кавычек и запятых внутри. */
    public static List<String[]> csvRows(String resourceName, int columnCount) {
        InputStream resource = TestData.class.getResourceAsStream(resourceName);
        if (resource == null) {
            throw new IllegalStateException("Не найден ресурс " + resourceName);
        }
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",", -1);
                if (columns.length != columnCount) {
                    throw new IllegalStateException("Некорректная строка " + resourceName + ": " + line);
                }
                rows.add(columns);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось прочитать " + resourceName, e);
        }
        return rows;
    }
}
