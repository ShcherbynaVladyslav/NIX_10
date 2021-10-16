package ua.com.alevel;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    public  void run() {

        System.out.println("Начните ввод данных для подсчитывания символов (Кроме цифр, !;%: итд.)");
        Scanner qq = new Scanner(System.in);

        String arr = qq.next();

        char[] crr1 = arr.toCharArray();

        char[] sec2 = new char[crr1.length];

        int[] nums3 = new int[sec2.length];
        Arrays.fill(nums3, 0);

        boolean is = true;
        int count = 0;

        for (char c:crr1) {
            if (!Character.isLetter(c)) continue;
            for (int q = 0; q <= count; q++) {
                if (sec2[q] == c) {
                    nums3[q]++;
                    is = false;
                    break;
                }
                is = true;
            }
            if (is) {
                sec2[count] = c;
                nums3[count]++;
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + sec2[i]+" - "+ nums3[i]);
        }
    }
}