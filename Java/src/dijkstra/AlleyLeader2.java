package dijkstra;

import java.io.*;
import java.util.*;

public class AlleyLeader2 {

  static int A, B, N, M;
  static long answer, C;
  static long[] dist;
  static ArrayList<Edge>[] array;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Long.parseLong(st.nextToken());

    dist = new long[N + 1];
    array = new ArrayList[N + 1];
    for (int i = 0; i <= N; i++) array[i] = new ArrayList<Edge>();

    Long max = Long.MIN_VALUE;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      long c = Long.parseLong(st.nextToken());
      max = Math.max(max, c);

      array[a].add(new Edge(b,c));
      array[b].add(new Edge(a,c));
    }

    answer = binary(max);
    System.out.println(answer);
  }

  static private long binary(long max) {
    long answer = -1;

    long start = 0;
    long end = max;

    while (start <= end) {
      long mid = (start + end) / 2;

      if (!Dijkstra(A, mid)) {
        start = mid + 1;
      } else {
        answer = mid;
        end = mid - 1;
      }
    }

    return answer;
  }

  static boolean Dijkstra(int x, long cost) {
    Arrays.fill(dist, Long.MAX_VALUE);

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(x,0));

    dist[x] = 0;

    while (!pq.isEmpty()) {
      Edge now = pq.poll();
      if (dist[now.to]<now.weight) continue;

      for (Edge next : array[now.to]) {
        if (cost >= next.weight && dist[next.to] > dist[now.to] + next.weight) {
          dist[next.to] = dist[now.to] + next.weight;
          pq.add(new Edge(next.to, dist[next.to]));
        }
      }
    }

    return dist[B] <= C;
  }

}

class Edge implements Comparable<Edge> {
  int to;
  long weight;

  public Edge(int x, long weight) {
    this.to = x;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge o) {
    return Long.compare(this.weight, o.weight);
  }
}