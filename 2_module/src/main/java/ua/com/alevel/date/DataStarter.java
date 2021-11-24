package ua.com.alevel.date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataStarter {

    private static final String file = "2_module/src/main/resources/txt/dates.txt";

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        boolean loop = true;
        while (loop) {
            System.out.println("\n" +
                    "1. Для чтения дат из файла dates.txt\n" +
                    "2. Для ручного ввода даты\n" +
                    "0. Для выхода" +
                    "\n");
            String position = null;
            try {
                position = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (position) {
                case "1":
                    Path path = Paths.get(file);
                    try {
                        List<String> notDoneList = Files.readAllLines(path);
                        notDoneList.forEach(System.out::println);
                        System.out.println("Отформатированные даты:");
                        String[] outDate = DateController.fixDate(notDoneList);
                        for (String doneList : outDate) {
                            if (!doneList.equals("")) {
                                System.out.println(i + " " + doneList);
                                i++;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        List<String> notDoneList;
                        System.out.println("Введите даты, разделяя их пробелами.");
                        notDoneList = List.of(reader.readLine().split(" "));
                        String[] formattedDates = DateController.fixDate(notDoneList);
                        for (String dateWithoutDelimiters : formattedDates) {
                            if (!dateWithoutDelimiters.equals("")) {
                                System.out.println(dateWithoutDelimiters);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "0": {
                    loop = false;
                }
            }
        }
    }
}