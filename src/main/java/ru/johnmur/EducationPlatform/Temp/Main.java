package ru.johnmur.EducationPlatform.Temp;

import java.util.*;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + " лет)";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 18));
        students.add(new Student("Charlie", 20));

        students.sort(Comparator.comparing(s -> s.age));

        System.out.println(students); // Выведет: [Alice (22 лет), Bob (18 лет), Charlie (20 лет)]
    }
}

