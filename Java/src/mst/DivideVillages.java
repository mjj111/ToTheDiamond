package mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DivideVillages {
  static class Edge implements Comparable<Edge> {
    int from, to, cost;

    Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.cost, o.cost);
    }
  }

  static int[] parent;

  static int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 정점 수
    int m = sc.nextInt(); // 간선 수

    List<Edge> edges = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      edges.add(new Edge(a, b, c));
    }

    // 간선 정렬
    Collections.sort(edges);

    parent = new int[n + 1];
    for (int i = 1; i <= n; i++) parent[i] = i;

    int total = 0;
    int maxCost = 0;
    int count = 0;

    for (Edge e : edges) {
      if (find(e.from) != find(e.to)) {
        union(e.from, e.to);
        total += e.cost;
        maxCost = e.cost; // 정렬된 순서이므로 마지막으로 연결된 간선이 가장 비쌈
        count++;
        if (count == n - 1) break;
      }
    }

    System.out.println(total - maxCost); // 가장 비싼 간선 제거하여 두 마을로 분리
  }
}
