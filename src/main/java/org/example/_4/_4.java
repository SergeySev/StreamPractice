package org.example._4;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class _4 {
    //4*. Дан стрим Stream stream = Stream.of("we", "wee", "qwer", "oooo");
    // (или любой другой…не суть)
    // Вывести на экран СТРИМОМ самую длинную строку. Если несколько одинаковых, то значит несколько.

    public static void longestStrings(Stream<String> stream) {
        AtomicInteger longestLength = new AtomicInteger(-1);
        stream.peek(string -> {
                    if (string.length() > longestLength.get()) {
                        longestLength.set(string.length());
                    }
                }).sorted(Comparator.comparing(String::length).reversed())
                .takeWhile(string -> string.length() == longestLength.get())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        longestStrings(Stream.of("we", "wee", "qwer", "oooo"));
    }
}
