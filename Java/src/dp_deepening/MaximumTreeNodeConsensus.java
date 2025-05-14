package dp_deepening;

import java.util.*;

public class MaximumTreeNodeConsensus {
  static List<Integer>[] tree;
  static long[] dp;
  static long[] weight;
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    tree = new ArrayList[n];
    for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      tree[a].add(b);
      tree[b].add(a);
    }

    weight = new long[n];
    for (int i = 0; i < n; i++) weight[i] = sc.nextLong();


    dp = new long[n];
    Arrays.fill(dp, Long.MIN_VALUE);

    boolean[] visited = new boolean[n];
    dfs(0, visited);

    System.out.println(dp[0]);
  }

  static void dfs(int cur, boolean[] visited) {
    visited[cur] = true;
    dp[cur] = weight[cur];

    for (int next : tree[cur]) {
      if (visited[next]) continue;
      dfs(next, visited);
      dp[cur] = Math.max(dp[cur] + dp[next], dp[cur]);
    }
  }
}
