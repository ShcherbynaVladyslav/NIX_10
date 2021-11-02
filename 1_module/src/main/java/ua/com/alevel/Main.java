package ua.com.alevel;

import ua.com.alevel.one.ArrayOfNumbers;
import ua.com.alevel.one.Chess;
import ua.com.alevel.one.Triangle;
import ua.com.alevel.two.BracketMain;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i = 1;

        ArrayOfNumbers arrayOfNumbers = new ArrayOfNumbers();
        Chess chess = new Chess();
        Triangle triangle = new Triangle();
        BracketMain bracketMain = new BracketMain();
        while (i != 0) {
            System.out.println("Введите номер задания (1, 2, 3, 4)");
            System.out.println("Для выхода - 0");

            Scanner in = new Scanner(System.in);
            int q = in.nextInt();

            if (q == 1) arrayOfNumbers.run(args);
            else if (q == 2) chess.run();
            else if (q == 3) triangle.run();
            else if (q == 4) bracketMain.run();
            else if (q == 0) {
                System.out.println("Завершение.");
                i = 0;
            } else System.out.println("Такого варианта нету");
        }
    }
}
