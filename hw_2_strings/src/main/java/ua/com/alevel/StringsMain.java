package ua.com.alevel;

import java.util.Scanner;

public class StringsMain {
    public static void main(String[] args) {
        System.out.println("Выберите номер задания");
        Scanner in = new Scanner(System.in);
        int numb = in.nextByte();
        switch (numb) {
            case 1: {
                System.out.println("Начните ввод строки");
                Scanner l = new Scanner(System.in);
                String s = l.nextLine();
                System.out.println(StringLib.reverse(s));
            }
            case 2: {
                System.out.println("Начните ввод строки ");
                Scanner l = new Scanner(System.in);
                String str = l.nextLine();
                System.out.println("Введите подстроку для ревёрса");
                String revsrt = l.next();
                System.out.println(StringLib.reverseSubstring(str, revsrt));
            }
            case 3: {
                System.out.println("Начните ввод строки ");
                Scanner l = new Scanner(System.in);
                String str = l.nextLine();
                System.out.println("Введите первый индекс");
                int fitst =l.nextInt();
                System.out.println("Введите второй индекс");
                int two =l.nextInt();
                System.out.println(StringLib.reverseIndex(str, fitst, two));
            }
        }
    }
}