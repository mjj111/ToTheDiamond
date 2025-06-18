package floyd;

import java.util.*;

public class Ignition {
  static final int INF = Integer.MAX_VALUE;
  static int[][] d = new int[205][205];
  static List<int[]> edges = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    for (int i = 1; i <= n; i++)
      Arrays.fill(d[i], INF);

    for (int i = 1; i <= n; i++)
      d[i][i] = 0;

    for (int i = 0; i < m; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();
      int l = sc.nextInt();
      d[s][e] = Math.min(d[s][e], l);
      d[e][s] = Math.min(d[e][s], l);
      edges.add(new int[]{s, e, l});
    }

    for (int k = 1; k <= n; k++)
      for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
          if (d[i][k] != INF && d[k][j] != INF)
            d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

    double ans = INF;
    for (int i = 1; i <= n; i++) {
      double totalTime = 0;
      for (int[] edge : edges) {
        int s = edge[0], e = edge[1], l = edge[2];
        double time = (l + d[i][s] + d[i][e]) / 2.0;
        totalTime = Math.max(totalTime, time);
      }
      ans = Math.min(ans, totalTime);
    }

    System.out.printf("%.1f\n", ans);
  }
}
