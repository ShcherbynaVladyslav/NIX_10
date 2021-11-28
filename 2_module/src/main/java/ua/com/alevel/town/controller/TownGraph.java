package ua.com.alevel.town.controller;

import ua.com.alevel.town.entity.Cities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TownGraph {

    public static int numOfCities;
    public static List<Cities> cities = new ArrayList<>();
    public static final String file = "2_module/src/main/resources/txt/input.txt";

    public static void run() throws FileNotFoundException {
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
                city.setNeighborsId(city.getNeighbor().keySet().stream().toList());
                cities.add(city);
                System.out.println(city);
            }
            int wayNeedFind = Integer.parseInt(reader.readLine());
            System.out.println(wayNeedFind);
            for (int i = 0; i < wayNeedFind; i++) {
                String[] nameOfTwoCities = nameWayModel(reader.readLine());
                System.out.println(nameOfTwoCities[0] + " - " + nameOfTwoCities[1]);
                shortestWay(findByName(nameOfTwoCities[0]), findByName(nameOfTwoCities[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void shortestWay(Cities firsTown, Cities twoTown) {
        int nowCost = 0;
        if (ItsNeighbor(firsTown, twoTown)) {
            LastCost(nowCost, firsTown.getNeighborValueFromMap(twoTown.getId()));
        } else Loop(firsTown, twoTown);
    }

    public static void Loop(Cities firstTown, Cities twoTown) {
        List<Integer> commonNeighbors = new ArrayList<>();
        for (int i = 0; i < firstTown.getNeighborsValue(); i++) {
            for (int j = 0; j < twoTown.getNeighborsValue(); j++) {
                if (firstTown.getNeighborsIdByElement(i).equals(twoTown.getNeighborsIdByElement(j))) {
                    commonNeighbors.add(firstTown.getNeighborsIdByElement(i));
                }
            }
        }
        int[] allCost = new int[commonNeighbors.size()];
        int needed;
        for (int i = 0; i < commonNeighbors.size(); i++) {
            allCost[i] = (WayCost(findById(commonNeighbors.get(i)).getId(), firstTown.getId()));
            System.out.println("Цена из города " + (findById(commonNeighbors.get(i)).getName()) + " в город " + (findById(firstTown.getId()).getName()) + " = " + allCost[i]);
            System.out.println();
        }
        int[] second = Arrays.copyOf(allCost, allCost.length);
        int min = allCost[0];
        int indexMin=0;
        for (int i = 0; i < allCost.length; i++) {
            if (allCost[i] < min) {
                min = allCost[i];
                indexMin = i;
                System.out.println("index min = "+indexMin);
                indexMin--;
            }
        }
        Arrays.sort(allCost);
        int newCost = min;
        System.out.println("index min = "+indexMin);
        System.out.println("id " + commonNeighbors.get(indexMin));
        int nowCost = WayCost(findById(commonNeighbors.get(indexMin)).getId(), twoTown.getId());
        System.out.println("общие соседи: ");
        System.out.println(commonNeighbors);
        LastCost(nowCost, newCost);
    }

    public static int WayCost(int one, int two) {
        int nowCost = (findById(one).getNeighborValueFromMap(two));
        return nowCost;
    }

    public static void LastCost(int nowCost, int newCost) {
        int finalCost = nowCost + newCost;
        System.out.println("Стоимость пути: " + finalCost);
    }

    public static boolean ItsNeighbor(Cities firstTown, Cities twoTown) {
        List<Integer> neighborList = firstTown.getNeighborsId();
        for (int i = 0; i < firstTown.getNeighborsValue(); i++)
            if (neighborList.get(i).equals(twoTown.getId())) {
                return true;
            }
        return false;
    }

    public static Cities findById(int id) {
        for (Cities cities : cities)
            if (cities.getId() == id) {
                return cities;
            }
        return null;
    }

    public static Cities findByName(String nam) {
        for (Cities cities : cities)
            if (cities.getName().equals(nam)) {
                return cities;
            }
        return null;
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