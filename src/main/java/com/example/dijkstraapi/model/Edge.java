package com.example.dijkstraapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Edge {
    private int vertex;
    private int weight;
}
