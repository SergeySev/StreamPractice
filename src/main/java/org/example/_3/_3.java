package org.example._3;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _3 {
    //    3**. Дана строка  String ss = "KikJhYeggTgf" (это пример)
    //    вывести на экран кол-во букв в верхнем и нижнем регистре используя СТРИМЫ
    public static void countLetters(String str) {
        // str = str.toLowerCase();
        //        Map<String, Integer> result =
        //                Arrays.stream(str.split(" "))
        //                        .toList().stream()
        //                        .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        char[] charArray = str.toCharArray();
        List<int[]> result = Stream
                .iterate(new int[]{0, 0, 0}, x -> new int[]{
                        (Character.isUpperCase(charArray[x[2]]) ? ++x[0] : x[0]),
                        (Character.isLowerCase(charArray[x[2]]) ? ++x[1] : x[1]),
                        ++x[2]})
                .limit(charArray.length + 1)
                .toList();

        int sizeResult = result.size();
        System.out.println("String: " + str
                + "\nHas " + result.get(sizeResult - 1)[0] + " Upper case letter"
                + "\nand " + result.get(sizeResult - 1)[1] + " Lower case letter");
    }
    public static void countLetterTwoStreams(String str) {
        long countLowerCase = str.chars()
                .filter(Character::isLetter)
                .filter(letter -> letter - Character.toLowerCase(letter) == 0)
                .count();
        long countUpperCase = str.chars()
                .filter(Character::isLetter)
                .filter(letter -> letter - Character.toUpperCase(letter) == 0)
                .count();
        System.out.println("String: " + str
                + "\nHas " + countUpperCase + " Upper case letter"
                + "\nand " + countLowerCase+ " Lower case letter");
    }

    public static void main(String[] args) {
        countLetters("AAbb");
        countLetterTwoStreams("AAbb");
    }
}
