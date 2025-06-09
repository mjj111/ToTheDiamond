package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class AlmostShortPath {
  static final int INF = Integer.MAX_VALUE;

  static class Edge {
    int to, weight;
    public Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static int N, M, S, D;
  static List<Edge>[] graph;
  static List<Integer>[] reverseGraph;
  static int[] dist;
  static boolean[][] isShortestEdge;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      if (N == 0 && M == 0) break;

      st = new StringTokenizer(br.readLine());
      S = Integer.parseInt(st.nextToken());
      D = Integer.parseInt(st.nextToken());

      graph = new ArrayList[N];
      reverseGraph = new ArrayList[N];
      isShortestEdge = new boolean[N][N];

      for (int i = 0; i < N; i++) {
        graph[i] = new ArrayList<>();
        reverseGraph[i] = new ArrayList<>();
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        graph[u].add(new Edge(v, p));
        reverseGraph[v].add(u); // 역방향 저장 (역추적용)
      }

      // Step 1: 최단 경로 구하기
      dijkstra();

      // Step 2: 최단 경로에 포함된 간선들 추적
      removeShortestPaths(D);

      // Step 3: 제거 후 다시 다익스트라
      int result = dijkstraWithoutShortestEdges();

      System.out.println(result == INF ? -1 : result);
    }
  }

  static void dijkstra() {
    dist = new int[N];
    Arrays.fill(dist, INF);
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    dist[S] = 0;
    pq.offer(new Edge(S, 0));

    while (!pq.isEmpty()) {
      Edge cur = pq.poll();

      if (dist[cur.to] < cur.weight) continue;

      for (Edge next : graph[cur.to]) {
        if (dist[next.to] > dist[cur.to] + next.weight) {
          dist[next.to] = dist[cur.to] + next.weight;
          pq.offer(new Edge(next.to, dist[next.to]));
        }
      }
    }
  }

  static void removeShortestPaths(int dest) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(dest);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int prev : reverseGraph[now]) {
        for (Edge edge : graph[prev]) {
          if (edge.to == now && dist[now] == dist[prev] + edge.weight) {
            if (!isShortestEdge[prev][now]) {
              isShortestEdge[prev][now] = true;
              queue.add(prev);
            }
          }
        }
      }
    }
  }

  static int dijkstraWithoutShortestEdges() {
    int[] newDist = new int[N];
    Arrays.fill(newDist, INF);
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    newDist[S] = 0;
    pq.offer(new Edge(S, 0));

    while (!pq.isEmpty()) {
      Edge cur = pq.poll();

      if (newDist[cur.to] < cur.weight) continue;

      for (Edge next : graph[cur.to]) {
        if (isShortestEdge[cur.to][next.to]) continue; // 최단 경로 간선 제외

        if (newDist[next.to] > newDist[cur.to] + next.weight) {
          newDist[next.to] = newDist[cur.to] + next.weight;
          pq.offer(new Edge(next.to, newDist[next.to]));
        }
      }
    }

    return newDist[D];
  }
}
