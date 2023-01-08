package org.example._7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class _7 {
    //    7. Взять наш класс Student (или сделать свой) 
    //    изменить имена и фамилии на заглавные и сгруппировать по курсу стримом

    public static Map<Integer, List<Student>> _7_(Student[] arr) {
        return Arrays.stream(arr)
                .peek(s -> s.setName(s.getName().toUpperCase()))
                .peek(student -> student.setLastName(student.getLastName()))
                .collect(Collectors.groupingBy(Student::getCourse));
    }
    
    public static void main(String[] args) {
        Student[] students = new Student[10];
        Random random = new Random();
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("Bob", "notBob", random.nextInt(1, 5));
        }

        System.out.println(_7_(students));
    }
    
}
