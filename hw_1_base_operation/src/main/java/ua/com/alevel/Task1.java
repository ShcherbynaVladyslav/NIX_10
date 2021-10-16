package ua.com.alevel;

import java.util.Scanner;

public class Task1 {

    public void run() {
        System.out.println("Начните вводить данные для вычленения всех чисел.");
        Scanner qq = new Scanner(System.in);
        String arr = qq.nextLine();
        char[] crr = arr.toCharArray();
        int res = 0;


        for (int i = 0; i < crr.length; i++) {
            if ((byte)crr[i]>=48 && (byte)crr[i]<=57) res += (byte) crr[i] - 48;
        }

        for (int i = 0; i < crr.length; i++) System.out.println(crr[i]);
        System.out.println(res);



    }
}