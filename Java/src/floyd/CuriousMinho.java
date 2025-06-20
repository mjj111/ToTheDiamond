package floyd;

import java.util.Scanner;

public class CuriousMinho {
  static int n;
  static int[][] d = new int[22][22];
  static boolean[][] u = new boolean[22][22];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++)
        d[i][j] = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) continue;
        boolean isUnit = true;

        for (int k = 1; k <= n; k++) {
          if (k == i || k == j) continue;
          int tmp = d[i][k] + d[k][j];

          if (tmp < d[i][j]) {
            System.out.println(-1);
            return;
          } else if (tmp == d[i][j]) {
            isUnit = false;
          }
        }

        if (isUnit) {
          u[i][j] = true;
          u[j][i] = true;
        }
      }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++)
      for (int j = i + 1; j <= n; j++)
        if (u[i][j]) ans += d[i][j];

    System.out.println(ans);
  }
}
