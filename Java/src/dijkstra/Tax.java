package dijkstra;

import java.util.*;

public class Tax {
  static class Edge {
    int to, cost;
    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

  static class Node implements Comparable<Node> {
    int to, cost, edges;
    Node(int to, int cost, int edges) {
      this.to = to;
      this.cost = cost;
      this.edges = edges;
    }

    public int compareTo(Node o) {
      return Integer.compare(this.cost, o.cost);
    }
  }

  static final int INF = Integer.MAX_VALUE;
  static List<Edge>[] graph;
  static int[][] dist;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();

    int S = sc.nextInt();
    int D = sc.nextInt();

    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int w = sc.nextInt();
      graph[u].add(new Edge(v, w));
      graph[v].add(new Edge(u, w));
    }

    int[] taxes = new int[K];
    for (int i = 0; i < K; i++) {
      taxes[i] = sc.nextInt();
    }

    dist = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      Arrays.fill(dist[i], INF);
    }

    dijkstra(S, N);

    int answer = INF;
    for (int i = 0; i <= N; i++) {
      answer = Math.min(answer, dist[D][i]);
    }
    System.out.println(answer);

    // 세금 인상 처리
    int taxSum = 0;
    for (int t = 0; t < K; t++) {
      taxSum += taxes[t];
      int min = INF;
      for (int i = 0; i <= N; i++) {
        if (dist[D][i] < INF) {
          min = Math.min(min, dist[D][i] + taxSum * i);
        }
      }
      System.out.println(min);
    }
  }

  static void dijkstra(int start, int N) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0, 0));
    dist[start][0] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (dist[cur.to][cur.edges] < cur.cost) continue;

      for (Edge next : graph[cur.to]) {
        int nextCost = cur.cost + next.cost;
        int nextEdges = cur.edges + 1;

        if (nextEdges > N) continue;

        if (dist[next.to][nextEdges] > nextCost) {
          dist[next.to][nextEdges] = nextCost;
          pq.offer(new Node(next.to, nextCost, nextEdges));
        }
      }
    }
  }
}

