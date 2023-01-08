package org.example._2;

import java.util.List;
import java.util.stream.Stream;

public class _2 {
    //            2****. Написать 3 метода который выводит на экран ЗНАЧЕНИЕ числа Фибоначчи. Как выглядит ряд - погуглите [0 1 1 2 3 5 8 13 21 44……]
//    input -> 5
//    out -> 5
//
//    input -> 8
//    out -> 21
//
//    НАПИСАТЬ 3-МЯ СПОСОБАМИ [просто цикл, стримом, рекурсией]
    public static int fibonacciCycle(int num) {
        //  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
        //  89, 144, 233, 377, 610, 987, 1597,
        //  2584, 4181, 6765, 10946, 17711
        if (num == 0) return 0;
        else if (num == 1 || num == 2) return 1;

        int firsNum = 0;
        int secondNum = 1;
        int result = firsNum + secondNum;
        for (int i = 2; i < num; i++) {
            firsNum = secondNum;
            secondNum = result;
            result = firsNum + secondNum;
        }
        return result;
    }

    public static int fibonacciRecursion(int num) {
        if (num == 0) return 0;
        else if (num == 1 || num == 2) return 1;
        return fibRecHelp(num,  1, 1);
    }

    public static int fibRecHelp(int num, int secondNum, int result) {
        int firstNum = secondNum;
        secondNum = result;
        result = firstNum + secondNum;
        --num;

        if (num == 2) return result;
        return fibRecHelp(num, secondNum, result);
    }

    public static int fibonacciStream(int num) {
        if (num == 0) return 0;
        else if (num == 1 || num == 2) return 1;
        List<int[]> result = Stream
                .iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(num)
                .toList();
        int[] finalArray = result.get(result.size() - 1);
        return finalArray[finalArray.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(fibonacciCycle(3));
        System.out.println(fibonacciRecursion(8));
        System.out.println((fibonacciStream(5)));
    }
}
