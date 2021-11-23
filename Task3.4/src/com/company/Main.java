package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Node { // КЛАСС – СТРУКТУРА ЭЛЕМЕНТА СПИСКА
    public int value; // значение
    public Node next; // поле – ссылка (указатель) на следующий узел

    Node(int value, Node next) { // конструктор класса
        this.value = value;
        this.next = next;
    }
}

public class Main { // ГЛАВНЫЙ КЛАСС

    // ввод элементов списка
    public static Node inputList(Node tail, int n, Scanner sc) {
        // добавление элементов с наращиванием хвоста
        for (int i = 0; i < n; i++) {
            int newItemValue = sc.nextInt();
            tail.next = new Node(newItemValue, null);
            tail = tail.next;
        }
        return tail;
    }

    // вывод элементов на экран
    public static String getListString(Node head) {
        String output = "Элементы списка:";
        Node ref = head; // ref – рабочая переменная для текущего узла
        while (ref != null) {
            output += " " + ref.value;
            ref = ref.next;
        }
        return output;
    }

    public static int sumOfEven(Node head) {
        Node ref = head; // ref – рабочая переменная для текущего узла
        int sum = 0;
        while (ref != null) {
            if (ref.value % 2 == 0) {
                sum += ref.value;

            }
            ref = ref.next;
        }
        return sum;
    }

    public static int evenCount(Node head) {
        Node ref = head; // ref – рабочая переменная для текущего узла
        int count = 0;
        while (ref != null) {
            if (ref.value % 2 == 0) {
                count += 1;
            }
            ref = ref.next;
        }
        return count;
    }

    public static double averageValue(int sum, int count) {
        return sum / count;
    }

    public static int getMin(Node head) {
        int min = Integer.MAX_VALUE;

        while (head != null) {
            if (min > head.value && head.value>0) {
                min = head.value;
            }
            head = head.next;
        }
        return min;
    }

    public static int getMax(Node head) {
        int max = Integer.MIN_VALUE;

        while (head != null) {
            if (max < head.value && head.value>0) {
                max = head.value;
            }
            head = head.next;
        }
        return max;
    }

    public static void main(String[] args) { // Главный метод (точка входа в программу)
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        // создание 1-го узла, который изначально является и головой, и хвостом списка
        Node head = new Node(1, null);
        Node tail = head;

        System.out.print("Введите количество элементов:");
        int n = sc.nextInt();
        tail = inputList(tail, n, sc);
        System.out.println(getListString(head));

        int sum = sumOfEven(head); // сумма четных чисел
        int count = evenCount(head); // количество четных чисел
        double avg = averageValue(sum, count); // среднее значение среди четных чисел
        System.out.println("Сумма четных чисел: " + sum);
        System.out.println("Количество четных чисел: " + count);
        System.out.println("Среднее значение среди четных чисел: " + avg);
        int min = getMin(head), max = getMax(head);
        System.out.println("Минимальное число: " + min + " Максимальное: " + max);
    }
}
