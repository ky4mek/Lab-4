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
        // добавление элементов с перемещением головы (наращивание с головы)
        Node head = null;

        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }

        // вывод элементов на экран
        Node ref = head; // ref – рабочая переменная для текущего узла
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
