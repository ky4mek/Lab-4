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

    public static Node createHead(int newValue, Node head) {
        Node newHead = new Node(newValue, head); // новая голова = (значение нового элемента(головы), старая голова)
        return newHead;
    }

    public static Node createHeadRec(int newValue, Node head, int i) {
        if (i == 1) {
            Node newHead = new Node(newValue, head); // новая голова = (значение нового элемента(головы), старая голова)
            return newHead;
        }
        return createHeadRec(newValue, head, i + 1);
    }

    public static Node createTail(int newValue, Node head) {
        // создается новый элемент со значением – будущий хвост
        Node newTail = new Node(newValue, null);

        // для перемещения по списку используется вспомогательная переменная ref,
        // которой в качестве начальной ссылки передается указатель на «голову»
        Node ref = head;

        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = newTail;

        return ref;
    }

    public static Node createTailRec(int newValue, Node head) {
        // создается новый элемент со значением – будущий хвост
        Node newTail = new Node(newValue, null);

        // для перемещения по списку используется вспомогательная переменная ref,
        // которой в качестве начальной ссылки передается указатель на «голову»
        Node ref = head;

        if (head == null) {
            return ref;
        }

        ref = ref.next;
        ref = newTail;
        return createTailRec(newValue, ref);
    }

    // вывод элементов на экран
    public static String getListString(Node head) {
        String output = "Элементы списка: ";
        Node ref = head; // ref – рабочая переменная для текущего узла
        while (ref != null) {
            output += " " + ref.value;
            ref = ref.next;
        }
        return output;
    }

    // вывод элементов на экран через рекурсию
    public static String getListStringRec(Node head, String output) {
        if (head == null) {
            return output;
        }

        Node ref = head; // ref – рабочая переменная для текущего узла
        output += " " + ref.value;
        return getListStringRec(head.next, output);
    }

    public static Node AddFirst(int newValue, Node head) {
        Node newHead = new Node(newValue, head); // новая голова = (значение нового элемента(головы), старая голова)
        return newHead;
    }

    public static Node AddLast(int newValue, Node head) {
        // создается новый элемент со значением – будущий хвост
        Node newTail = new Node(newValue, null);

        // для перемещения по списку используется вспомогательная переменная ref,
        // которой в качестве начальной ссылки передается указатель на «голову»
        Node ref = head;

        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = newTail;

        return ref;
    }

    public static Node Insert(int newValue, int num, Node head) {
        // создается новый элемент со значением newValue для вставки
        Node newNode = new Node(newValue, null);
        Node ref = head; // используем временную переменную
        int k = 1; // счетчик элементов

        // поиск нужного положения узла для вставки
        while (ref.next != null && (k < num)) {
            ref = ref.next;
            k++;
        }
        // переброска ссылок при вставке элемента
        newNode.next = ref.next.next;
        ref.next = newNode;
        return ref;
    }

    public static Node RemoveFirst(Node head) {
        head = head.next;
        return head;
    }

    public static Node RemoveLast(Node head) {
        Node ref = head; // создаем вспомогательную переменную
        // перемещаемся на предпоследний элемент
        while (ref.next.next != null) {
            ref = ref.next;
        }
        // полю next предпоследнего элемента присваиваем null
        ref.next = null;
        return ref;
    }

    public static Node Remove(int num, Node head) {
        Node ref = head; // создаем вспомогательную переменную
        int k = 1; // счетчик элементов

        // поиск положения узла, предшествующего удаляемому
        while (ref.next != null && (k < num)) {
            ref = ref.next;
            k++;
        }
        // переброска ссылки для исключения ненужного элемента из списка
        ref.next = ref.next.next;
        return ref;
    }

    public static void main(String[] args) { // Главный метод (точка входа в программу)
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        Node head = null;
        int x;

        System.out.println("Введите x для добавления с головы:");
        x = sc.nextInt();
        head = createHead(x, head);
        System.out.println(getListString(head));

        System.out.println("Введите x для добавления с хвоста:");
        x = sc.nextInt();
        head = createTail(x, head);
        System.out.println(getListString(head));
    }
}
