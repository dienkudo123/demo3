package com.example.dijkstraapi.Controller;

import com.example.dijkstraapi.model.DijkstraResult;
import com.example.dijkstraapi.model.Graph;
import com.example.dijkstraapi.service.DijkstraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DijkstraController {

    @Autowired
    private DijkstraService dijkstraService;

    @PostMapping("/dijkstra")
    public Map<String, Object> dijkstra(@RequestBody Map<String, Object> payload) {
        int n = (int) payload.get("n");
        int start = (int) payload.get("start");
        int end = (int) payload.get("end");
        var edges = (List<Map<String, Integer>>) payload.get("edges");



        Graph graph = new Graph(n);
        for (var edge : edges) {
            int u = edge.get("u");
            int v = edge.get("v");
            int weight = edge.get("weight");
            graph.addEdge(u, v, weight);
            graph.addEdge(v, u, weight);
        }

        DijkstraResult result = dijkstraService.dijkstra(n, start, end, graph);
        Map<String, Object> response = new HashMap<>();
        response.put("path", result.getPath());
        response.put("distance", result.getDistance());
        System.out.println(response);
        return  response;
    }
}
