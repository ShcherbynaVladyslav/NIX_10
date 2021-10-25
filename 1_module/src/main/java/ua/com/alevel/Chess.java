package ua.com.alevel;

import java.util.Scanner;

public class Chess {
    public  void run() {
        char lit, needLit;
        int num, needNum;

        System.out.println("Введите положение фигуры по оси х (буква, верхний регистр)");
        Scanner in = new Scanner(System.in);

        lit = in.next().charAt(0);
        if (lit < (char) 65 || lit > (char) 90) {
            System.out.println("Заданная вами буква не подходит.");
            System.exit(0);
        }
        System.out.println("Введите положение фигуры по оси y (цифра)");
        num = in.nextInt();
        if (num < 0 || num > 26) {
            System.out.println("Заданная вами цифра не подходит.");
            System.exit(0);
        }

        System.out.println("Введите позицию на которую хотите сходить");
        needLit = in.next().charAt(0);
        if (needLit < (char) 65 || needLit > (char) 90) {
            System.out.println("Заданная вами буква не подходит.");
            System.exit(0);
        }

        needNum = in.nextInt();
        System.out.println("Введите положение фигуры по оси y (цифра)");
        if (needNum < 0 || needNum > 26) {
            System.out.println("Заданная вами цифра не подходит.");
            System.exit(0);
        }
        System.out.println("Нужная вам позиция = " + needLit + needNum);

        if ((needNum - num == 1) || (needNum - num == -1)) {
            if ((needLit - lit == 2) || (needLit - lit == -2)) {
                System.out.println("Такой ход возможен");
            } else System.out.println("Такой ход невозможен");
        } else if ((needNum - num == 2) || (needNum - num == -2)) {

            if ((needLit - lit == 1) || (needLit - lit == -1)) {
                System.out.println("Такой ход возможен");
            } else System.out.println("Такой ход невозможен");
        } else System.out.println("Такой ход невозможен");
    }
}