class Node { // КЛАСС – СТРУКТУРА ЭЛЕМЕНТА СПИСКА
    public int value; // значение
    public Node next; // поле – ссылка (указатель) на следующий узел

    Node(int value, Node next) { // конструктор класса
        this.value = value;
        this.next = next;
    }
}

public class Main { // ГЛАВНЫЙ КЛАСС
    public static void main(String[] args) {
        // создание 1-го узла, который изначально является и головой, и хвостом списка
        Node head = new Node(0, null);
        Node tail = head;
        // добавление элементов с наращиванием хвоста
        for (int i = 0; i < 9; i++) {
            tail.next = new Node(i + 1, null);
            tail = tail.next; // указатель на созданный элемент запоминается как указатель на новый хвост
        }
        // вывод элементов на экран
        Node ref = head; // ref – рабочая переменная для текущего узла
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
