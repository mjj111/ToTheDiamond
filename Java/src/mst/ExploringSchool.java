package mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExploringSchool {
  static final int MX = 1000;
  static int[] p = new int[MX + 2];
  static int n, m, ans = 0;
  static List<Edge> edges = new ArrayList<>();

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

  static boolean isDiffGroup(int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v) return false;
    if (p[u] > p[v]) {
      int tmp = u;
      u = v;
      v = tmp;
    }
    p[u] += p[v];
    p[v] = u;
    return true;
  }

  static void solve(boolean isMaxCalc) {
    Arrays.fill(p, -1);
    int sum = 0, cnt = 0;
    for (Edge edge : edges) {
      if (!isDiffGroup(edge.u, edge.v)) continue;
      sum += edge.cost;
      cnt++;
      if (cnt == n) break;
    }
    if (isMaxCalc) ans += sum * sum;
    else ans -= sum * sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt() + 1;

    for (int i = 0; i < m; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int cost = sc.nextInt();  // 0 or 1
      edges.add(new Edge(cost == 0 ? 1 : 0, u, v));  // 0은 힘든 길로 바꿈
    }

    Collections.sort(edges);
    solve(false);

    Collections.sort(edges, Collections.reverseOrder());
    solve(true);

    System.out.println(ans);
  }
}