package ru.homework.support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/** Общие сообщения для каждого теста, повтора и набора параметров. */
public abstract class TestLifecycle {
    @BeforeEach
    protected void printStart() {
        System.out.println("========================Test method start");
    }

    @AfterEach
    protected void printEnd() {
        System.out.println("Test method end");
        System.out.println("========================");
    }
}
