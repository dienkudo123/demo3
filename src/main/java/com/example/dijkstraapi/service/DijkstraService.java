package com.example.dijkstraapi.service;

import com.example.dijkstraapi.model.DijkstraResult;
import com.example.dijkstraapi.model.Edge;
import com.example.dijkstraapi.model.Graph;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DijkstraService {

    public DijkstraResult dijkstra(int n, int start, int end, Graph graph) {
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[1];
            int d = current[0];

            if (d > dist[u]) continue;

            for (Edge edge : graph.getAdjList().get(u)) {
                int v = edge.getVertex();
                int weight = edge.getWeight();
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        if (dist[end] == Integer.MAX_VALUE) {
            return new DijkstraResult(Collections.emptyList(), -1);
        } else {
            List<Integer> path = new ArrayList<>();
            int curr = end;
            while (curr != -1)
            {
                path.add(curr);
                curr = parent[curr];
            }
            return new DijkstraResult(path, dist[end]);
        }
    }
}
