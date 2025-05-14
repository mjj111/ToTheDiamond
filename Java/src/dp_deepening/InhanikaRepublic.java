package dp_deepening;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InhanikaRepublic {
  static class Edge {
    int to, cost;
    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

  static List<Edge>[] graph;

  // u: 현재 노드, parent: 부모 노드, parentEdgeCost: 부모와의 연결 다리 비용
  static int dfs(int u, int parent, int parentEdgeCost) {
    int total = 0;

    for (Edge edge : graph[u]) {
      int v = edge.to;
      int cost = edge.cost;
      if (v == parent) continue;

      int childCost = dfs(v, u, cost);
      total += childCost;
    }

    if (total == 0) return parentEdgeCost; // 자식이 없는 리프노드인 경우
    return Math.min(total, parentEdgeCost);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // 테스트 케이스 수

    while (T-- > 0) {
      int N = sc.nextInt();
      int M = sc.nextInt();

      graph = new ArrayList[N + 1];
      for (int i = 1; i <= N; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < M; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int d = sc.nextInt();
        graph[u].add(new Edge(v, d));
        graph[v].add(new Edge(u, d));
      }

      int answer = 0;
      for (Edge edge : graph[1]) {
        int v = edge.to;
        int cost = edge.cost;
        int childCost = dfs(v, 1, cost);
        answer += childCost;
      }

      System.out.println(answer);
    }
  }
}
