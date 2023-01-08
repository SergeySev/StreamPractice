package org.example._13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class _13 {
    //13**Написать метод
//    input -> 221
//    out -> 122
//
//    input -> int b = -123
//    out -> -321
    public static int reverseInt(int num) {
        AtomicReference<String> result = new AtomicReference<>("");
        String.valueOf(Arrays.stream(Integer.toString(Math.abs(num))
                        .split(""))
                .map(el -> {
                    result.set(el + result);
                    return result;
                })
                .toList().toString());
        int answer = Integer.parseInt(result.toString());
        return (num < 0) ? -answer : answer;
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(-123));
    }
}
