package org.example._8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class _8 {
    // Вывести 7 самых больших чисел из массива чисел Стримом
    public static void sevenTheBiggerNumbers(Integer[] arr) {
        Stream.of(arr).sorted(Comparator.reverseOrder())
                .limit(7)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        sevenTheBiggerNumbers(arr);
    }
}
