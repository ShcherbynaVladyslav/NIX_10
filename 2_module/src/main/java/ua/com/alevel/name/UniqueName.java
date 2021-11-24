package ua.com.alevel.name;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UniqueName {

    private static final String file = "2_module/src/main/resources/txt/names.txt";

    public static void run() {
        try {
            Path path = Paths.get(file);
            ArrayList<String> names = (ArrayList<String>) Files.readAllLines(path);
            System.out.println("Имена которые находяться в файле:");
            System.out.println(names);
            System.out.println("\nПервое уникальное имя: ");
            System.out.println(findUniqueName(names));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String findUniqueName(List<String> names) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String name : names) {
            map.compute(name, (key, value) -> (value != null) ? value + 1 : 1);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return "Уникальные имена отсутствуют.";
    }
}