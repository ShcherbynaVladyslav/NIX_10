package ua.com.alevel;

import java.util.Scanner;

public class Task3 {

    public  void run() {
        System.out.println("Время конца какого урока требуется?");
        Scanner enter = new Scanner(System.in);

        int start = 9 * 60;
        int oneLesson = 45;
        int firstPause = 5;
        int twoPause = 15;
        int needKnow = enter.nextInt();
        int res;
        int sPl = start + needKnow * oneLesson;

        res = sPl + ((needKnow - 1) / 2) * twoPause + (needKnow / 2) * firstPause;
        System.out.println(res / 60 + ":" + res % 60);
    }
}