package org.example.week6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class week6Assignment {
    // Метод сортировки
    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Сравнение двух элементов
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    // Меняем элементы местами
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Точка входа в программу
    public static void main(String[] args) {
        // Список чисел
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(1);
        intList.add(4);
        intList.add(2);

        // Сортировка по возрастанию
        sort(intList, Comparator.naturalOrder());
        System.out.println("Sorted integer list: " + intList);

        // Список строк
        List<String> stringList = new ArrayList<>();
        stringList.add("Charlie");
        stringList.add("Alice");
        stringList.add("Bob");

        // Сортировка строк по длине (убывание)
        sort(stringList, Comparator.comparing(String::length).reversed());
        System.out.println("Sorted string list (descending order): " + stringList);
    }
}