package com.example.loggingTest;

import jakarta.servlet.Servlet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ErrorServiceTest {
    @Test
    void sdsdf() throws Exception {
        // given

        // when
        Class<ClassLoader> aClass = ClassLoader.class;

        ClassLoader classLoader = aClass.getClassLoader();

        Object o2 = new Object();
        ClassLoader classLoader6 = o2.getClass().getClassLoader();

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();



        // then
        System.out.println(classLoader6);
        System.out.println(systemClassLoader);
        System.out.println(platformClassLoader);

        /*Arrays.stream(classLoader4.getDefinedPackages())
                .forEach(System.out::println);
        System.out.println();

        Arrays.stream(platformClassLoader.getDefinedPackages())
                .forEach(System.out::println);*/

        Class<?> superclass = systemClassLoader.getClass().getSuperclass();
        while (superclass != null) {
            System.out.println();
            Arrays.stream(superclass.getInterfaces())
                    .forEach(i -> System.out.print(i.getName() + " "));
            System.out.println();
            System.out.println(superclass);
            superclass = superclass.getSuperclass();
        }
        System.out.println("--------------------");
        superclass = platformClassLoader.getClass().getSuperclass();
        while (superclass != null) {
            System.out.println();
            Arrays.stream(superclass.getInterfaces())
                    .forEach(i -> System.out.print(i.getName() + " "));
            System.out.println();
            System.out.println(superclass);
            superclass = superclass.getSuperclass();
        }

        System.out.println("--------------------");

        ClassLoader parent = platformClassLoader.getParent();
        System.out.println("platformClassLoader");
        while(parent != null) {
            System.out.println(parent);
            parent = parent.getParent();
        }

        parent= systemClassLoader.getParent();
        System.out.println("systemClassLoader");
        while(parent != null) {
            System.out.println(parent);
            parent = parent.getParent();
        }

    }
}