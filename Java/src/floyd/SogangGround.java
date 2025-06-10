package floyd;

import java.io.*;
import java.util.*;

public class SogangGround {
  static int n, m, r;
  static final int INF = 987987987;

  static int[] item = new int[102];
  static boolean[] vis = new boolean[102];

  static int[][] d = new int[102][102];
  static int[][] nxt = new int[102][102];

  static void visit(int i, int j) {
    int cur = i;
    while (cur != j) {
      vis[cur] = true;
      cur = nxt[cur][j];
    }
    vis[j] = true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      item[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= n; i++) {
      Arrays.fill(d[i], INF);
      d[i][i] = 0;
    }

    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());
      d[x][y] = dist;
      d[y][x] = dist;
      nxt[x][y] = y;
      nxt[y][x] = x;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          int tmp = d[i][k] + d[k][j];
          if (tmp < d[i][j]) {
            d[i][j] = tmp;
            nxt[i][j] = nxt[i][k];
          }
        }
      }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) {
      Arrays.fill(vis, false);
      int tmpSum = 0;

      for (int j = 1; j <= n; j++) {
        if (d[i][j] <= m) {
          visit(i, j);
        }
      }
      for (int j = 1; j <= n; j++) {
        if (vis[j]) {
          tmpSum += item[j];
        }
      }
      ans = Math.max(ans, tmpSum);
    }

    System.out.println(ans);
  }
}
