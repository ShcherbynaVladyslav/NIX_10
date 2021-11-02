package ua.com.alevel.two;

import java.util.Scanner;

public class BracketMain {

    public void run() {
        int z = 1;
        while (z != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("Начните ввод строки для проверки на допустимость.");
            String s = in.next();
            Bracket bracket = new Bracket();
            if (bracket.isValid(s)) System.out.println("Строка допустим");
            else System.out.println("Строка не допустима");
            System.out.println("Повторить задание? 1 - да, 2 - нет");
            int q = in.nextInt();
            if (q == 1) System.out.println("");
            else if (q == 2) z = 0;
            else {
                System.out.println("Вы играете не по правилам");
                System.exit(0);
            }
        }
    }
}