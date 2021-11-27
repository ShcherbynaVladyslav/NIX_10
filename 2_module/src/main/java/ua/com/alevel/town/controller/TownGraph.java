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
            for (int i = 1; i <= numOfCities; i++) {
                Cities city = new Cities();
                city.setName(reader.readLine());
                city.setId(i);
                int neighborsVal = Integer.parseInt(reader.readLine());
                city.setNeighborsValue(neighborsVal);
                for (int j = 1; j <= city.getNeighborsValue(); j++) {
                    int[] arrayFromModel = neighborsWayModel(reader.readLine());
                    city.toMap(arrayFromModel[0], arrayFromModel[1]);
                }
                cities.add(city);
                System.out.println(city);
            }
            int wayNeedFind = Integer.parseInt(reader.readLine());
            System.out.println(wayNeedFind);
            for (int i = 0; i < wayNeedFind; i++) {
                String[] nameOfTwoCities = nameWayModel(reader.readLine());
                String firstTown = nameOfTwoCities[0];
                String twoTown = nameOfTwoCities[1];
                System.out.println(firstTown + " - " + twoTown);
            }
            //расстановка соседей
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void shortestWay(int idOne, int idTwo) {
        int result = 0;
        System.out.println(result);
    }


    private static int[] neighborsWayModel(String fullString) {
        String[] stringsWay = fullString.split(" ");
        int firstIndex = Integer.parseInt(stringsWay[0]);
        int twoIndex = Integer.parseInt(stringsWay[1]);
        return new int[]{firstIndex, twoIndex};
    }

    private static String[] nameWayModel(String fullString) {
        String[] stringsName = fullString.split(" ");
        String firstName = stringsName[0];
        String twoName = stringsName[1];
        return new String[]{firstName, twoName};
    }

}