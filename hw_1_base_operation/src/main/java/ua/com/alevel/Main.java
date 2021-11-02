package ua.com.alevel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Выберете номер задачи (1, 2, 3) ");
        Scanner in = new Scanner(System.in);
        int ss = in.nextInt();
        String s = "---------------------------------------------------------------------------------";

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();

        if (ss == 1) {
            System.out.println("Вы выбрали 1");
            System.out.println(s);
            task1.run();

        } else if (ss == 2) {
            System.out.println("Вы выбрали 2");
            System.out.println(s);
            task2.run();


        } else if (ss == 3) {
            System.out.println("Вы выбрали 3");
            System.out.println(s);
            task3.run();
        } else System.out.println("error");
    }
}
