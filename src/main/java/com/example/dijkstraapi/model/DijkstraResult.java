package com.example.dijkstraapi.model;

import java.util.List;

public class DijkstraResult {
    private List<Integer> path;
    private int distance;

    public DijkstraResult(List<Integer> path, int distance) {
        this.path = path;
        this.distance = distance;
    }

    public List<Integer> getPath() {
        return path;
    }

    public int getDistance() {
        return distance;
    }
}
