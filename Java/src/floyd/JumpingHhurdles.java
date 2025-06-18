package floyd;

import java.util.Arrays;
import java.util.Scanner;


public class JumpingHhurdles {
  static final int MX = 300;
  static final int INF = Integer.MAX_VALUE;
  static int[][] h = new int[MX + 1][MX + 1];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int t = sc.nextInt();

    for (int i = 1; i <= n; i++)
      Arrays.fill(h[i], INF);

    for (int i = 1; i <= n; i++)
      h[i][i] = 0;

    for (int i = 0; i < m; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int height = sc.nextInt();
      h[u][v] = height;
    }

    for (int k = 1; k <= n; k++)
      for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
          h[i][j] = Math.min(h[i][j], Math.max(h[i][k], h[k][j]));

    for (int i = 0; i < t; i++) {
      int st = sc.nextInt();
      int en = sc.nextInt();
      if (h[st][en] == INF)
        System.out.println(-1);
      else
        System.out.println(h[st][en]);
    }
  }
}
