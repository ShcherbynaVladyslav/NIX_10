package ua.com.alevel.town.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cities {
    private String name;
    private int id;
    private int neighborsValue;
    private final Map<Integer, Integer> neighbor = new HashMap<>();
    private List<Integer> neighborsId = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNeighborsValue() {
        return neighborsValue;
    }

    public void setNeighborsValue(int neighborsValue) {
        this.neighborsValue = neighborsValue;
    }

    public Map<Integer, Integer> getNeighbor() {
        return neighbor;
    }


    public void toMap(int indexOfCity, int price) {
        neighbor.put(indexOfCity, price);
    }


    public List<Integer> getNeighborsId() {
        return neighborsId;
    }

    public void setNeighborsId(List<Integer> neighborsId) {
        this.neighborsId = neighborsId;
    }


    @Override
    public String toString() {
        return "Cities{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", neighborsValue=" + neighborsValue +
                ", neighbors=" + neighbor +
                ", neighborsId=" + neighborsId +
                '}';
    }

}
