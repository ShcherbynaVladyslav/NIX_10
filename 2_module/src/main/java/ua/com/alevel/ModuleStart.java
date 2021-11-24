package ua.com.alevel;

import ua.com.alevel.date.DataStarter;
import ua.com.alevel.name.UniqueName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModuleStart {

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            navigation();
            try {
                String position;
                position = reader.readLine();
                if (position.equals("0")) loop = false;
                run(position);

            } catch (IOException e) {
                System.out.println("problem: = " + e.getMessage());
            }
        }
    }

    public static void run(String position) throws IOException {
        switch (position) {
            case "1" -> DataStarter.run();
            case "2" -> UniqueName.run();
            case "0" -> System.exit(0);
        }
    }

    private static void navigation() {
        System.out.println();
        System.out.println("Выберите номер задания.");
        System.out.println("1. Задание с датами");
        System.out.println("2. Задание с именами");
        System.out.println("0. Выход");
        System.out.println();
    }
}
