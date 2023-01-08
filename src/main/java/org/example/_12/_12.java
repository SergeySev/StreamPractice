package org.example._12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _12 {
    //12 ** Написать метод, который принимает стрингу
    // из нескольких слов и возвращает перевернутое предложение. ВОЗВРАЩАЕМОЕ ЗНАЧЕНИЕ STRING!
    // Input -> my name is
    // out -> is name my
    public static String reverseString(String str) {
        AtomicReference<String> reverse = new AtomicReference<>("");

        String[] arString = str.split(" ");
        Arrays.stream(arString).map(word -> {
            reverse.set(word + " " + reverse);
            return reverse;
        }).toList().toString();
        String answer = reverse.toString();
        return answer.substring(0, answer.length() - 1);
    }


    public static void main(String[] args) {
        String s = "my name is";
        System.out.println(reverseString(s));
    }
}
