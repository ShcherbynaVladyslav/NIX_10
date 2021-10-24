package ua.com.alevel;

import java.util.Scanner;

public class Triangle {
    public  void run() {

        int a = 0, b = 0;
        Scanner in = new Scanner(System.in);
        double[][] mmas1 = new double[3][2];
        for (int i = 0; i < mmas1.length; i++) {
            for (int j = 0; j < mmas1[i].length; j++) {
                System.out.println("Введите сторону " + (char) (65 + a) + " по оси  " + (char) (120 + b));
                mmas1[i][j] = in.nextInt();
                b++;
            }
            if (b > 0) b = 0;
            a++;
            System.out.println();
        }

        double x13 = (mmas1[0][0] - mmas1[2][0]);
        double y13 = (mmas1[0][1] - mmas1[2][1]);
        double x23 = (mmas1[1][0] - mmas1[2][0]);
        double y23 = (mmas1[1][1] - mmas1[2][1]);

        double semiPer = 0.5 * ((x13 * y23) - (x23 * y13));


        for (int i = 0; i < mmas1.length; i++) {
            for (int j = 0; j < mmas1[i].length; j++) {
                System.out.println("x " + i + " y " + j + " = " + mmas1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Math.abs(semiPer) + " ответ");
    }
}