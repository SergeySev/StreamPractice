package org.example._9;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _9 {
//9*. Дано String s = "AAGGTFFDDVVAA" или похожая.
//    Вывести на экран кол-во повторений в таком виде
//"4A2G1T2F2D2V"
//
//
//        **Если в стринге есть какие то другое символы кроме букв - выбросить исключение

    public static void quantityLetter(String str) throws Exception {
        if (!str.chars().allMatch(Character::isLetter)) {
            throw new Exception("The string contains more than just letters");
        }
        System.out.println("ASD + " + str.chars());
        Map<String, Integer> map = Arrays.stream(str.split(""))
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.print(entry.getValue() + entry.getKey());
        }
    }

    public static void main(String[] args) throws Exception {
        quantityLetter("hjkукцуABBDDD");
    }
}
