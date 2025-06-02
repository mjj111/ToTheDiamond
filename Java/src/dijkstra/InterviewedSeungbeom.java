package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class InterviewedSeungbeom {

  private static BufferedReader br;

  private static int N, M, K;
  private static List<List<Edge>> adjList;
  private static int[] interviewRooms;
  private static final long INF = Long.MAX_VALUE;

  private static class Edge implements Comparable<Edge> {
    int num;
    long dist;

    private Edge(int num, long dist) {
      this.num = num;
      this.dist = dist;
    }

    @Override
    public int compareTo(Edge o) {
      return Long.compare(dist, o.dist);
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input();

    bw.write(solve());
    bw.close();
  }

  private static String solve() {
    StringBuilder sb = new StringBuilder();

    long[] ret = BFS();
    long max = -1;
    int num = 0;
    for (int i = 1; i <= N; i++) {
      if (ret[i] != INF) {
        if (max < ret[i]) {
          max = ret[i];
          num = i;
        }
      }
    }

    sb.append(num).append('\n').append(max);
    return sb.toString();
  }

  private static long[] BFS() {
    PriorityQueue<Edge> que = new PriorityQueue<>();
    long[] dists = new long[N + 1];
    boolean[] isVisited = new boolean[N + 1];
    Arrays.fill(dists, INF);

    for (int t : interviewRooms) {
      que.offer(new Edge(t, 0));
      dists[t] = 0;
    }

    while (!que.isEmpty()) {
      Edge cur = que.poll();

      if (isVisited[cur.num]) continue;
      if (cur.dist > dists[cur.num]) continue;
      isVisited[cur.num] = true;

      for (Edge next : adjList.get(cur.num)) {
        if (dists[next.num] > dists[cur.num] + next.dist) {
          dists[next.num] = dists[cur.num] + next.dist;
          que.offer(new Edge(next.num, dists[next.num]));
        }
      }
    }

    return dists;
  }

  private static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    adjList = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      adjList.get(v).add(new Edge(u, w));
    }
    interviewRooms = new int[K];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      interviewRooms[i] = Integer.parseInt(st.nextToken());
    }
  }
}