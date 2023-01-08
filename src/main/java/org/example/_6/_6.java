package org.example._6;

import java.util.Arrays;

public class _6 {
    //    6. Дан массив интов - вывести на экран все четные числа
    public static void printOdd(int[] arr) {
        Arrays.stream(arr).filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7};
        printOdd(ar);
    }
}
