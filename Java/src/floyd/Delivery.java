package floyd;

import java.util.Arrays;
import java.util.Scanner;

public class Delivery {
  static final int INF = Integer.MAX_VALUE / 2 -1;
  static int n, m;
  static int[][] d;
  static int[][] nxt;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    d = new int[n + 1][n + 1];
    nxt = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      Arrays.fill(d[i], INF);
      d[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      d[a][b] = c;
      d[b][a] = c;

      nxt[a][b] = b;
      nxt[b][a] = a;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (d[i][k] + d[k][j] < d[i][j]) {
            d[i][j] = d[i][k] + d[k][j];
            nxt[i][j] = nxt[i][k];
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          System.out.print("- ");
        } else {
          System.out.print(nxt[i][j] + " ");
        }
      }
      System.out.println();
    }
  }
}