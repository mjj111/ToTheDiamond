package mst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CommunionWithGodOfTheUniverse {
  static class Edge implements Comparable<Edge> {
    long dist;
    int u, v;

    Edge(long dist, int u, int v) {
      this.dist = dist;
      this.u = u;
      this.v = v;
    }

    public int compareTo(Edge o) {
      return Long.compare(this.dist, o.dist);
    }
  }

  static int[] parent;
  static int find(int x) {
    if (parent[x] < 0) return x;
    return parent[x] = find(parent[x]);
  }

  static boolean merge(int a, int b) {
    a = find(a); b = find(b);
    if (a == b) return false;
    if (parent[a] == parent[b]) parent[a]--;
    if (parent[a] < parent[b]) parent[b] = a;
    else parent[a] = b;
    return true;
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    parent = new int[n + 1];
    Arrays.fill(parent, -1);

    int[][] coords = new int[n + 1][2];
    for (int i = 1; i <= n; i++) {
      coords[i][0] = sc.nextInt();
      coords[i][1] = sc.nextInt();
    }

    int cnt = 0;
    for (int i = 0; i < m; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      if (merge(x, y)) cnt++;
    }

    List<Edge> edges = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        int dx = coords[i][0] - coords[j][0];
        int dy = coords[i][1] - coords[j][1];
        long dist = 1L * dx * dx + 1L * dy * dy;
        edges.add(new Edge(dist, i, j));
      }
    }

    Collections.sort(edges);

    double total = 0;
    for (Edge edge : edges) {
      if (!merge(edge.u, edge.v)) continue;
      total += Math.sqrt(edge.dist);
      cnt++;
      if (cnt == n - 1) break;
    }

    System.out.printf("%.2f\n", total);
  }
}
