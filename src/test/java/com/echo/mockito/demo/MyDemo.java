package com.echo.mockito.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sun.awt.geom.Crossings;

import java.util.Random;

public class MyDemo {

    @Test
    void test() {
        Random mock = Mockito.mock(Random.class);
//        System.out.println(mock.nextInt());
        Mockito.verify(mock).nextInt();
    }
}
