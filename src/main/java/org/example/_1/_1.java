package org.example._1;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _1 {
    public static void quantityWord(String str) {
        //    1.**** Создать стрим который принимает на вход Стрингу,
        //    а на выходе выводит на экран кол-во слов и повторений данного слова:
        //    input-> my name is
        //    out -> my : 1
        //    name : 1
        //    is : 1
        if (str.length() == 0 || str.equals(" ")) {
            System.out.println("String has no words");
            return;
        }
        str = str.toLowerCase();
        Map<String, Integer> result =
                Arrays.stream(str.split(" "))
                        .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        System.out.println(result);
    }

    public static void main(String[] args) {
        String st = "ThIs is ThiS WorD word this is    ";
        String s = "my name is";
        quantityWord(s);
    }
}
