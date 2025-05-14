package dp_deepening;

import java.util.*;

public class ExcellentVillage {
  static int N;
  static int[] population;
  static ArrayList<Integer>[] tree;
  static int[][] dp;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    population = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      population[i] = sc.nextInt();
    }

    tree = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      tree[u].add(v);
      tree[v].add(u);
    }

    dp = new int[N + 1][2];  // [0]: 우수 마을 아님, [1]: 우수 마을
    visited = new boolean[N + 1];

    dfs(1);

    System.out.println(Math.max(dp[1][0], dp[1][1]));
  }

  static void dfs(int cur) {
    visited[cur] = true;
    dp[cur][0] = 0;
    dp[cur][1] = population[cur];

    for (int next : tree[cur]) {
      if(visited[next]) continue;
      dfs(next);
      dp[cur][0] += Math.max(dp[next][0], dp[next][1]); // 우수마을이 아니라면 자식은 우수던지 우수가 아니던지 괜찮다.
      dp[cur][1] += dp[next][0];  // 우수 마을이면 자식은 못 됨
    }
  }
}
