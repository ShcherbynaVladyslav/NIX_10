package ua.com.alevel.one;

import java.util.Scanner;

public class Triangle {
    public void run() {

        int z = 1;
        while (z != 0) {

            int a = 0, b = 0;
            Scanner in = new Scanner(System.in);
            double[][] mmas1 = new double[3][2];
            for (int i = 0; i < mmas1.length; i++) {
                for (int j = 0; j < mmas1[i].length; j++) {
                    System.out.println("Введите сторону " + (char) (65 + a) + " по оси  " + (char) (120 + b));
                    mmas1[i][j] = in.nextInt();
                    if (b > 0) b = 0;
                    else b++;
                }
                a++;
                System.out.println();
            }

            double x13 = (mmas1[0][0] - mmas1[2][0]);
            double y13 = (mmas1[0][1] - mmas1[2][1]);
            double x23 = (mmas1[1][0] - mmas1[2][0]);
            double y23 = (mmas1[1][1] - mmas1[2][1]);

            double semiPer = 0.5 * ((x13 * y23) - (x23 * y13));


            System.out.println("Периметр =  " + Math.abs(semiPer));


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