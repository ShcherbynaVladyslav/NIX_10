package ua.com.alevel;

import java.util.Scanner;

public class ArrayOfNumbers {
    public void run(String[] args) {

        int count = 0;
        int superCount = 1;

        System.out.println("Старт");

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
            for (int j = 0; j == args.length  ; j++) {
                if (arr2[i] != arr2[j]) superCount++;
            }
        }

        System.out.println("SuperCount = "+superCount);

    }
}
