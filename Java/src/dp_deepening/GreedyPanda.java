package dp_deepening;

import java.util.Scanner;

public class GreedyPanda {
  static int[][] map, dp;
  static int n;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static int dfs(int x, int y) {
    if (dp[x][y] != 0) return dp[x][y];

    dp[x][y] = 1;
    for (int d = 0; d < 4; d++) {
      int nx = x + dx[d];
      int ny = y + dy[d];

      if(isOut(nx,ny))continue;
      if(map[nx][ny] <= map[x][y]) continue;

      dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
    }

    return dp[x][y];
  }
  private static boolean isOut(int x, int y) {
    return 0 > x || x > n-1 || 0 > y || y > n-1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    map = new int[n][n];
    dp = new int[n][n];

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        map[i][j] = sc.nextInt();

    int answer = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        answer = Math.max(answer, dfs(i, j));

    System.out.println(answer);
  }
}
