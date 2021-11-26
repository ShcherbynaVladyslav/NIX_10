package ua.com.alevel.town.controller;

import ua.com.alevel.town.entity.Cities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TownGraph {

    public static final String file = "2_module/src/main/resources/txt/input.txt";

    public static void run() throws FileNotFoundException {
        List<Cities> cities = new ArrayList<>();
        int numOfCities = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {
            if (reader.ready()) {
                numOfCities = Integer.parseInt(reader.readLine());
            }
            for (int i = 1; i < numOfCities; i++) {
                Cities city = new Cities();
                city.setName(reader.readLine());
                city.setId(i);
                int neighborsVal = Integer.parseInt(reader.readLine());
                city.setNeighborsValue(neighborsVal);
                for (int j = 1; j <= city.getNeighborsValue(); j++) {
                    int[] mmas = neighborsModel(reader.readLine());
                    city.toMap(mmas[0], mmas[1]);
                }
                cities.add(city);
                System.out.println(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] neighborsModel(String s) {
        String[] fileStrings = s.split(" ");
        int first = Integer.parseInt(fileStrings[0]);
        int two = Integer.parseInt(fileStrings[1]);
        return new int[]{first, two};
    }

}