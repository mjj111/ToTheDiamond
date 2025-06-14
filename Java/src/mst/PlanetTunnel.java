package mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PlanetTunnel {
  static class Edge implements Comparable<Edge> {
    int cost, a, b;
    Edge(int cost, int a, int b) {
      this.cost = cost;
      this.a = a;
      this.b = b;
    }

    public int compareTo(Edge other) {
      return Integer.compare(this.cost, other.cost);
    }
  }

  static class Planet {
    int x, y, z, index;

    Planet(int x, int y, int z, int index) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.index = index;
    }
  }

  static int[] parent;

  static int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    if (rootA < rootB) {
      int temp = rootA;
      rootA = rootB;
      rootB = temp;
    }
    parent[rootA] = rootB;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Planet[] planets = new Planet[n];
    parent = new int[n];

    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();
      planets[i] = new Planet(x, y, z, i);
      parent[i] = i;
    }

    List<Edge> edges = new ArrayList<>();

    // 축마다 정렬 후 인접한 노드만 간선 추가
    for (int dim = 0; dim < 3; dim++) {
      int finalDim = dim;
      Arrays.sort(planets, Comparator.comparingInt(p -> {
        if (finalDim == 0) return p.x;
        if (finalDim == 1) return p.y;
        return p.z;
      }));

      for (int i = 0; i < n - 1; i++) {
        int cost = 0;
        if (dim == 0)
          cost = Math.abs(planets[i].x - planets[i + 1].x);
        else if (dim == 1)
          cost = Math.abs(planets[i].y - planets[i + 1].y);
        else
          cost = Math.abs(planets[i].z - planets[i + 1].z);

        edges.add(new Edge(cost, planets[i].index, planets[i + 1].index));
      }
    }

    Collections.sort(edges);  // 최소 비용 순으로 정렬

    int answer = 0;
    for (Edge edge : edges) {
      if (find(edge.a) != find(edge.b)) {
        union(edge.a, edge.b);
        answer += edge.cost;
      }
    }

    System.out.println(answer);
  }
}