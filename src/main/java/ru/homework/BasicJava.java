package ru.homework;

import java.util.ArrayList;
import java.util.List;

/** Двенадцать методов из домашнего задания «Базовая Java». */
public final class BasicJava {
    private BasicJava() {
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static String checkAccess(int age) {
        if (age > 18) {
            return "Allowed";
        } else {
            return "Denied";
        }
    }

    public static boolean isPositive(int n) {
        return n >= 0 ? true : false;
    }

    public static String getGrade(int score) {
        if (score >= 0 && score <= 20) {
            return "E";
        } else if (score >= 21 && score <= 40) {
            return "D";
        } else if (score >= 41 && score <= 60) {
            return "C";
        } else if (score >= 61 && score <= 80) {
            return "B";
        } else if (score >= 81 && score <= 100) {
            return "A";
        } else {
            return "Error";
        }
    }

    public static String blastOff(int start) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            result.append(i).append(' ');
        }
        return result.append("Поехали!").toString();
    }

    public static int sumToN(int n) {
        int sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += (int) i;
        }
        return sum;
    }

    public static boolean hasBug(String[] messages) {
        if (messages == null) {
            return false;
        }
        for (String message : messages) {
            if ("Bug".equalsIgnoreCase(message)) {
                return true;
            }
        }
        return false;
    }

    public static String getEvenInRange(int start, int end) {
        StringBuilder result = new StringBuilder();
        // long предотвращает переполнение счётчика, когда end = Integer.MAX_VALUE.
        for (long i = start; i <= end; i++) {
            if (i % 2 == 0) {
                if (result.length() > 0) {
                    result.append(' ');
                }
                result.append(i);
            }
        }
        return result.toString();
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть null или пустым");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static String[] reverse(String[] arr) {
        if (arr == null) {
            return null;
        }
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    public static double calcAverage(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0.0;
        }
        long sum = 0;
        for (int number : list) {
            sum += number;
        }
        return (double) sum / list.size();
    }

    public static List<String> removeSpecificName(List<String> list, String nameToRemove) {
        List<String> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (String currentName : list) {
            if (nameToRemove == null) {
                if (currentName != null) {
                    result.add(currentName);
                }
            } else if (!nameToRemove.equals(currentName)) {
                result.add(currentName);
            }
        }
        return result;
    }
}
