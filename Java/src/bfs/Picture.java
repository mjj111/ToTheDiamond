package bfs;

import java.util.*;

public class Picture {
  static int n, m;
  static int[][] paper;
  static boolean[][] visited;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    paper = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        paper[i][j] = sc.nextInt();
      }
    }

    int count = 0;
    int maxArea = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (paper[i][j] == 1 && !visited[i][j]) {
          int area = bfs(i, j);
          maxArea = Math.max(maxArea, area);
          count++;
        }
      }
    }

    System.out.println(count);
    System.out.println(maxArea);
  }

  static int bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    visited[x][y] = true;
    queue.offer(new int[]{x, y});
    int area = 1;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int cx = cur[0];
      int cy = cur[1];

      for (int d = 0; d < 4; d++) {
        int nx = cx + dx[d];
        int ny = cy + dy[d];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (paper[nx][ny] == 1 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            queue.offer(new int[]{nx, ny});
            area++;
          }
        }
      }
    }

    return area;
  }
}
