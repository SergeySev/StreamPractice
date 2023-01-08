package org.example._10;

import java.util.Optional;
import java.util.stream.Stream;

public class _10 {
    //    10. Дана стринга String r = "otiwuklf'
//    Написать метод где вы вводите символ, а метод возвращает индекс.
//    Если буквы нет, то соответствующее сообщение

    public static int getIndex(String str, String findLetter){
        int index = Stream.of(str).toList().get(0).indexOf(findLetter);
        if (index == -1) {
            System.out.println("The letter not found");
        }
        return index;
    }

    public static void main(String[] args) {
        String r = "otiwuklf";
        System.out.println(getIndex(r, "1"));
    }
}
