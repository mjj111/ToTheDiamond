package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;



public class WalkLarge {
  static long[] dS, dE;
  static final Long INF = Long.MAX_VALUE;
  static Set<Integer> visited;
  static List<List<Edge>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    dS = new long[N+1];
    dE = new long[N+1];
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<Edge>());
      dS[i] = dE[i] = INF;
    }

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      graph.get(A).add(new Edge(B, C));
      graph.get(B).add(new Edge(A, C));
    }

    st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    long ans = 0;
    visited = new HashSet<Integer>();
    dijkstra(dS, S);
    dijkstra(dE, E);
    ans += dS[E];

    eraseNode(S, E);
    Arrays.fill(dE, Long.MAX_VALUE);
    dijkstra(dE, E);

    ans += dE[S];
    System.out.println(ans);
  }

  static class Edge implements Comparable<Edge> {
    int loc;
    long dist;

    public Edge(int loc, long dist) {
      this.loc = loc;
      this.dist = dist;
    }

    public int compareTo(Edge o) {
      return Long.compare(this.dist, o.dist);
    }
  }

  static void dijkstra(long[] dist, int start) {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(start, 0));
    dist[start] = 0;
    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      if (dist[cur.loc] < cur.dist) continue;
      for (Edge nxt: graph.get(cur.loc)) {
        if (visited.contains(nxt.loc)) continue;
        if (dist[nxt.loc] <= cur.dist + nxt.dist) continue;
        dist[nxt.loc] = cur.dist + nxt.dist;
        pq.offer(new Edge(nxt.loc, dist[nxt.loc]));
      }
    }
  }

  static void eraseNode(int S, int E) {
    int start = S, pre = S;
    while (start != E) {
      int min = Integer.MAX_VALUE;
      for (Edge nxt: graph.get(start)) {
        if (pre == nxt.loc) continue;
        if (dS[start] + nxt.dist + dE[nxt.loc] == dS[E]) {
          min = Math.min(min, nxt.loc);
        }
      }
      pre = start;
      start = min;
      if (start != E) visited.add(start);
    }
  }
}