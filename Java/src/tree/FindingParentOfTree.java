package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FindingParentOfTree {
  private static int[] parent;
  private static Map<Integer, List<Integer>> nodes;
  private static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    nodes = new HashMap<>();

    for(int i = 1; i <=N; i++) {
      nodes.put(i, new ArrayList<Integer>());
    }

    for(int i = 0; i < N-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      nodes.get(start).add(end);
      nodes.get(end).add(start);
    }

    visited = new boolean[N+1];
    parent = new int[N+1];
    findParent(1);

    for(int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }
  }

  private static void findParent(int now) {
    visited[now] = true;
    for(int next : nodes.get(now)) {
      if(visited[next]) continue;

      parent[next] = now;
      findParent(next);
    }
  }
}