package backtracking;

import java.io.*;
import java.util.*;

public class Bishop {

  static int n;
  static int[][] board;
  static boolean[][] visited;

  static int blackMax = 0;
  static int whiteMax = 0;

  static int[] dx = {1, -1, -1, 1};
  static int[] dy = {1, 1, -1, -1};

  static final int BLACK = 0;
  static final int WHITE = 1;
  static final int CAN = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    visited = new boolean[n][n];

    board = new int[n][n];
    List<int[]> blackList = new ArrayList<>();
    List<int[]> whiteList = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if ((i + j) % 2 == BLACK) blackList.add(new int[]{i, j});
        else whiteList.add(new int[]{i, j});
      }
    }

    dfs(0, blackList, 0, BLACK);
    dfs(0, whiteList, 0, WHITE);

    System.out.println(blackMax + whiteMax);
  }

  private static void dfs(int idx, List<int[]> list, int count, int color) {
    if (idx == list.size()) {
      if (color == BLACK) blackMax = Math.max(blackMax, count);
      else whiteMax = Math.max(whiteMax, count);
      return;
    }

    int[] p = list.get(idx);
    int x = p[0];
    int y = p[1];

    if (board[y][x] == CAN && canPosition(y, x)) {
      visited[y][x] = true;
      dfs(idx + 1, list, count + 1, color);
      visited[y][x] = false;
    }

    dfs(idx + 1, list, count, color);
  }

  private static boolean canPosition(int y, int x) {
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      while (check(ny, nx)) {
        if (visited[ny][nx]) return false;
        ny += dy[i];
        nx += dx[i];
      }
    }
    return true;
  }

  private static boolean check(int y, int x) {
    return y >= 0 && y < n && x >= 0 && x < n;
  }
}
