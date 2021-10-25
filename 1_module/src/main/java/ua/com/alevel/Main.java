package ua.com.alevel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберете номер задачи (1, 2, 3) ");
        Scanner in = new Scanner(System.in);
        int ss = in.nextInt();
        String s = "---------------------------------------------------------------------------------";

        Triangle triangle = new Triangle();
        ArrayOfNumbers arrayOfNumbers = new ArrayOfNumbers();
        Chess chess = new Chess();

        if (ss == 1) {
            System.out.println("Вы выбрали 1");
            System.out.println(s);
            triangle.run();

        } else if (ss == 2) {
            System.out.println("Вы выбрали 2");
            System.out.println(s);
            arrayOfNumbers.run(args);

        } else if (ss == 3) {
            System.out.println("Вы выбрали 3");
            System.out.println(s);
            chess.run();

        } else System.out.println("error");
    }
}
