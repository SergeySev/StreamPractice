package org.example._11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class _11 {
    //11***. Дан массив интов.
    // Написать метод в который вы передаете массив и еще одно число.
    // Метод должен ВЕРНУТЬ ИНДЕКС ДВУХ ЧИСЕЛ, СУММА КОТОРЫХ ДАЕТ ЭТО ЧИСЛО.
    // ЕСЛИ ТАКОВЫХ НЕТ - СООБЩЕНИЕ.

    public static int[] sumTwoIndex(int[] array, int num) {
        int lastIndex = array.length - 1;
        if (num > lastIndex + lastIndex - 1) {
            System.out.println("No such number");
            return new int[0];
        }
        int[] arrayForSum = {0, lastIndex};
        List<int[]> result = Stream
                .iterate(arrayForSum, arr -> {
                    int sum = arr[0] + arr[1];
                    if (sum < num) {
                        ++arr[0];
                        System.out.println("Increase arr[0] " + arr[0]);
                    } if (sum > num) {
                        --arr[1];
                        System.out.println("Decrease arr[1] " + arr[1]);

                    } else if (sum == num) return arr;
                    return arr;
                })
                .limit(array.length)
                .toList();
        return result.get(result.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(Arrays.toString(sumTwoIndex(arr, 19)));
    }
}
