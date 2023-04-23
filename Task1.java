// 1. Реализовать консольное приложение, которое:
// Принимает от пользователя и “запоминает” строки.
// Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, 
// а первая - последней.
// Если введено revert, удаляет предыдущую введенную строку из памяти.

package HomeworkJava4;



import java.util.LinkedList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> lineList = new LinkedList<>();

        while (true) {
            System.out.print("Введите строку: ");
            String inputLine = input.nextLine();

            if (inputLine.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }

            if (inputLine.equalsIgnoreCase("print")) {
                String temp = lineList.getFirst();
                lineList.set(0,lineList.get(lineList.size() - 1));
                lineList.set((lineList.size() - 1),temp);
                System.out.println("Измененный список: " + lineList.toString());
                input.close();
                break;
            }

            if (inputLine.equalsIgnoreCase("revert")) {
                System.out.println("Исходный список: " + lineList.toString());
                int previous = lineList.size() - 2;
                if (previous >= 0) {
                    lineList.remove(previous);
                    System.out.println("Удалили предыдущую строку: " + lineList.toString());
                    input.close();
                } else {
                    System.out.println("В списке " + lineList.size() + " строк");
                }
                break;
            }

           lineList.add(inputLine);
        }
    }
}