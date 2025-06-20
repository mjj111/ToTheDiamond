package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RoadPavement {
  static class Edge {
    int to;
    int cost;
    public Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

  static class Node implements Comparable<Node> {
    int city, pave;
    long time;

    public Node(int city, long time, int pave) {
      this.city = city;
      this.time = time;
      this.pave = pave;
    }

    public int compareTo(Node o) {
      return Long.compare(this.time, o.time);
    }
  }

  static int N, M, K;
  static List<Edge>[] graph;
  static long[][] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());  // 도시 수
    M = Integer.parseInt(st.nextToken());  // 도로 수
    K = Integer.parseInt(st.nextToken());  // 포장 가능 도로 수

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[u].add(new Edge(v, c));
      graph[v].add(new Edge(u, c));
    }

    dijkstra();

    long result = Long.MAX_VALUE;
    for (int i = 0; i <= K; i++) {
      result = Math.min(result, dist[N][i]);
    }
    System.out.println(result);
  }

  static void dijkstra() {
    dist = new long[N + 1][K + 1];
    for (int i = 1; i <= N; i++) {
      Arrays.fill(dist[i], Long.MAX_VALUE);
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[1][0] = 0;
    pq.add(new Node(1, 0, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (dist[cur.city][cur.pave] < cur.time) continue;

      for (Edge edge : graph[cur.city]) {
        // 1. 도로를 포장하지 않고 감
        if (dist[edge.to][cur.pave] > cur.time + edge.cost) {
          dist[edge.to][cur.pave] = cur.time + edge.cost;
          pq.add(new Node(edge.to, dist[edge.to][cur.pave], cur.pave));
        }

        // 2. 도로를 포장하고 감 (포장 가능하면)
        if (cur.pave < K && dist[edge.to][cur.pave + 1] > cur.time) {
          dist[edge.to][cur.pave + 1] = cur.time;
          pq.add(new Node(edge.to, dist[edge.to][cur.pave + 1], cur.pave + 1));
        }
      }
    }
  }
}
