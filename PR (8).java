import java.util.Scanner;

public class PR {

    static class MyList {

        private int[] data;
        private int size;

        public MyList(int capacity) {
            data = new int[capacity];
            size = 0;
        }

        public void add(int value) {

            if (size >= data.length) {
                throw new IllegalStateException("Буфер переповнений");
            }

            data[size] = value;
            size++;
        }

        public void add(int index, int value) {

            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Некоректний індекс");
            }

            if (size >= data.length) {
                throw new IllegalStateException("Буфер переповнений");
            }

            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }

            data[index] = value;
            size++;
        }

        public void remove(int index) {

            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Некоректний індекс");
            }

            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }

            size--;
        }

        public int get(int index) {

            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Некоректний індекс");
            }

            return data[index];
        }

        public int size() {
            return size;
        }

        public int capacity() {
            return data.length;
        }

        public void print() {

            if (size == 0) {
                System.out.println("Список порожній");
                return;
            }

            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyList list = new MyList(10);

        while (true) {

            System.out.println("\n      MENU      ");
            System.out.println("1. Додати в кінець");
            System.out.println("2. Додати за індексом");
            System.out.println("3. Видалити");
            System.out.println("4. Отримати елемент");
            System.out.println("5. Показати список");
            System.out.println("6. Розмір");
            System.out.println("7. Буфер");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            String choice = sc.nextLine();

            try {

                if (choice.equals("1")) {

                    System.out.print("Число: ");
                    int v = Integer.parseInt(sc.nextLine());
                    list.add(v);

                } else if (choice.equals("2")) {

                    System.out.print("Індекс: ");
                    int i = Integer.parseInt(sc.nextLine());

                    System.out.print("Значення: ");
                    int v = Integer.parseInt(sc.nextLine());

                    list.add(i, v);

                } else if (choice.equals("3")) {

                    System.out.print("Індекс: ");
                    int i = Integer.parseInt(sc.nextLine());
                    list.remove(i);

                } else if (choice.equals("4")) {

                    System.out.print("Індекс: ");
                    int i = Integer.parseInt(sc.nextLine());
                    System.out.println("Елемент: " + list.get(i));

                } else if (choice.equals("5")) {

                    list.print();

                } else if (choice.equals("6")) {

                    System.out.println("Розмір: " + list.size());

                } else if (choice.equals("7")) {

                    System.out.println("Буфер: " + list.capacity());

                } else if (choice.equals("0")) {

                    System.out.println("Вихід");
                    break;

                } else {
                    System.out.println("Невірний вибір");
                }

            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть число");

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Помилка індексу: " + e.getMessage());

            } catch (IllegalStateException e) {
                System.out.println("Помилка буфера: " + e.getMessage());
            }
        }
    }
}