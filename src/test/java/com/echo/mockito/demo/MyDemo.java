package com.echo.mockito.demo;

import com.echo.mockito.util.StaticUtils;
import org.junit.jupiter.api.*;
import org.mockito.*;
import sun.awt.geom.Crossings;

import java.util.Collections;
import java.util.Random;

public class MyDemo {

    @Mock
    private Random random;

    @Test
    void test() {
//        Random mock = Mockito.mock(Random.class);
//        MockitoAnnotations.openMocks(this);
        System.out.println(random.nextInt());
        Mockito.verify(random).nextInt();
        Mockito.verify(random, Mockito.times(1)).nextInt();
    }

    @Test
    @DisplayName("测试mock静态方法")
    void check() {
        Random random = Mockito.mock(Random.class, "test");
        Assertions.assertEquals(0, random.nextInt());
    }
    @Test
    @Disabled
    void testWhen() {
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt()).thenReturn(1);
        System.out.println("666");
        Assertions.assertEquals(1, random.nextInt());
    }

//    @Test
//    void testStatic() {
//        StaticUtils mock = Mockito.mock(StaticUtils.class);
//        Mockito.when(mock.range(10, 20)).thenReturn(Collections.singletonList(15));
//        Assertions.assertEquals(Collections.singletonList(15), mock.range(10, 20));
//    }
    @BeforeEach
    void testBefore() {
        System.out.println("before each");
        MockitoAnnotations.openMocks(this);
    }

    @BeforeAll
    static void testSetup() {
        System.out.println("before all");
    }

    @AfterEach
    void testAfter() {
        System.out.println("after each");
    }

    @Spy
    private Random spyRandow;

    @Test
    void spyAdd() {
        Mockito.when(spyRandow.nextInt()).thenReturn(3);
        Assertions.assertEquals(spyRandow.nextInt(), 3);
    }

    @Test
    void testStatic() {
        try (MockedStatic<StaticUtils> staticUtilsMockedStatic = Mockito.mockStatic(StaticUtils.class)) {
            staticUtilsMockedStatic.when(() -> StaticUtils.range(0, 10)).thenReturn(Collections.singletonList(5));
            Assertions.assertEquals(Collections.singletonList(5), StaticUtils.range(0, 10));

            staticUtilsMockedStatic.when(StaticUtils::name).thenReturn("Echo");
        }
        Assertions.assertEquals("Echo", StaticUtils.name());
    }

    @Test
    void name() {
        try (MockedStatic<StaticUtils> staticUtilsMockedStatic = Mockito.mockStatic(StaticUtils.class)) {
            staticUtilsMockedStatic.when(StaticUtils::name).thenReturn("Echo");
        }
        Assertions.assertEquals("Echo", StaticUtils.name());
    }
}
