package mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlanetConnect {
  static int[] p;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    p = new int[n];
    Arrays.fill(p, -1);

    List<Edge> edges = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int cost = sc.nextInt();
        if (i == j) continue;
        edges.add(new Edge(cost, i, j));
      }
    }

    Collections.sort(edges);

    long ans = 0;
    int cnt = 0;

    for (Edge edge : edges) {
      if (!merge(edge.u, edge.v)) continue;
      ans += edge.cost;
      cnt++;
      if (cnt == n - 1) break;
    }

    System.out.println(ans);
  }

  static class Edge implements Comparable<Edge> {
    int cost, u, v;

    Edge(int cost, int u, int v) {
      this.cost = cost;
      this.u = u;
      this.v = v;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.cost, o.cost);
    }
  }

  static int find(int x) {
    if (p[x] < 0) return x;
    return p[x] = find(p[x]);
  }

  static boolean merge(int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v) return false;
    if (p[u] == p[v]) p[u]--;
    if (p[u] < p[v]) p[v] = u;
    else p[u] = v;
    return true;
  }
}
