package ua.com.alevel.one;

import java.util.Scanner;

public class ArrayOfNumbers {
    public void run(String[] args) {

        int count = 0;
        int superCount = 1;
        int z = 1;
        while (z != 0) {
            System.out.println("Начните ввод строки для получения количества уникальных цифр");

            Scanner in = new Scanner(System.in);
            String s = in.nextLine();

            char[] arr1 = s.toCharArray();
            char[] arr2 = new char[arr1.length];

            for (char c : arr1) {
                if (Character.isDigit(c)) {
                    arr2[count] = c;
                    count++;
                }
            }

            for (int i = count; i < arr2.length; i++) {
                arr2[i] = arr2[0];
            }

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j == args.length; j++) {
                    if (arr2[i] != arr2[j]) superCount++;
                }
            }

            System.out.println("Количество уникальных цифр = " + superCount);
            System.out.println();

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
