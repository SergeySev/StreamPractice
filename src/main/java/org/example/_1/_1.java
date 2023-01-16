package org.example._1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _1 {
    public static void quantityWord(String str) {
        //    1.**** Создать стрим который принимает на вход String,
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

        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
    }


    public static void main(String[] args) throws FileNotFoundException {
        String path = "romeo.txt";
        quantityWordInBook(path);
    }

    private static void quantityWordInBook(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder allText = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] arr = formatString(line);
                for (String str : arr) {
                    if (!str.equals("") && !str.equals(" ")) {
                        allText.append(str).append(" ");
                    }
                }
            }
            quantityWord(String.valueOf(allText));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] formatString(String line) {
        line = line.replaceAll("[^a-zA-Z0-9-']", " ");
        line = line.replaceAll("\\R", " ");
        String[] arr = line.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].indexOf("'") == 0 || arr[i].lastIndexOf("'") == arr[i].length() - 1) {
                arr[i] = arr[i].replaceAll("'", "");
            }
        }
        return arr;
    }
}
