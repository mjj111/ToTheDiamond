package mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DivideVillages {
  static class Edge implements Comparable<Edge> {
    int cost, from, to;

    Edge(int cost, int from, int to) {
      this.cost = cost;
      this.from = from;
      this.to = to;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.cost, o.cost);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      adj.get(a).add(new int[]{c, b});
      adj.get(b).add(new int[]{c, a});
    }

    boolean[] visited = new boolean[n + 1];
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    visited[1] = true;

    for (int[] next : adj.get(1)) {
      pq.add(new Edge(next[0], 1, next[1]));
    }

    int cnt = 0, ans = 0, maxCost = 0;

    while (cnt < n - 1 && !pq.isEmpty()) {
      Edge edge = pq.poll();
      int cost = edge.cost;
      int b = edge.to;

      if (visited[b]) continue;

      visited[b] = true;
      ans += cost;
      maxCost = Math.max(maxCost, cost);
      cnt++;

      for (int[] next : adj.get(b)) {
        if (!visited[next[1]]) {
          pq.add(new Edge(next[0], b, next[1]));
        }
      }
    }

    System.out.println(ans - maxCost);
  }
}