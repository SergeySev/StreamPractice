package org.example._5;

import java.util.Arrays;
import java.util.Comparator;

public class _5 {
    //    5. Отсортировать строки в алфавитном порядке стримом и в обратном
    public static void ascSorted(String[] strings) {
        Arrays.stream(strings).sorted(Comparator.comparing(String::valueOf))
                .forEach(System.out::println);
    }
    public static void descSorted(String[] strings) {
        Arrays.stream(strings).sorted(Comparator.comparing(String::valueOf).reversed())
                .forEach(System.out::println);
    }

    public static void ascAndDescSort(String[] strings) {
        Arrays.stream(strings).sorted(Comparator.comparing(String::valueOf))
                .peek(System.out::println)
                .sorted(Comparator.comparing(String::valueOf).reversed())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        String[] str = {"b", "cdr", "aer"};
        ascSorted(str);
        descSorted(str);
        System.out.println();
        ascAndDescSort(str);
    }
}
