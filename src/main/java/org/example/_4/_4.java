package org.example._4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class _4 {
    //4*. Дан стрим Stream stream = Stream.of("we", "wee", "qwer", "oooo");
    // (или любой другой…не суть)
    // Вывести на экран СТРИМОМ самую длинную строку. Если несколько одинаковых, то значит несколько.

    public static void theLongestString(String[] strings) {
        int lengthLongestStr = Arrays.stream(strings)
                .max(Comparator.comparing(String::length))
                .get()
                .length();

        Stream.of(strings)
                .filter(s -> s.length() == lengthLongestStr)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        theLongestString(new String[]{"we", "wee", "qwer", "oooo"});
    }
}
