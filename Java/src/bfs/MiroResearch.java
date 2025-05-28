package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class MiroResearch {
  static int n, m;
  static int[][] maze;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt(); // 세로 길이
    m = sc.nextInt(); // 가로 길이
    sc.nextLine(); // 줄바꿈 처리

    maze = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < m; j++) {
        maze[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(bfs(0, 0));
  }

  static int bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    visited[x][y] = true;
    queue.offer(new int[]{x, y});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int cx = cur[0];
      int cy = cur[1];

      for (int d = 0; d < 4; d++) {
        int nx = cx + dx[d];
        int ny = cy + dy[d];

        // 범위 확인 및 방문 조건
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (maze[nx][ny] == 1 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            maze[nx][ny] = maze[cx][cy] + 1; // 이동거리 누적
            queue.offer(new int[]{nx, ny});
          }
        }
      }
    }

    return maze[n - 1][m - 1]; // 도착지점의 이동거리
  }
}
