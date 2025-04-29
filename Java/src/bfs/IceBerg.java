package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IceBerg {
  static int N, M;
  static int[][] map;
  static int[][] meltAmount;
  static boolean[][] visited;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    map = new int[N][M];

    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        map[i][j] = sc.nextInt();

    int year = 0;
    while (true) {
      int count = countIcebergs();
      if (count >= 2) {
        System.out.println(year);
        break;
      }
      if (count == 0) {
        System.out.println(0);
        break;
      }

      melt();
      year++;
    }
  }

  static void melt() {
    meltAmount = new int[N][M];

    // 각 칸마다 주변 바다(0) 수를 기록
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {

        if (map[i][j] > 0) {
          for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (inBounds(nx, ny) && map[nx][ny] == 0) {
              meltAmount[i][j]++;
            }
          }
        }
      }
    }

    // 실제 높이 감소 적용
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        map[i][j] = Math.max(0, map[i][j] - meltAmount[i][j]);
      }
    }
  }

  static int countIcebergs() {
    visited = new boolean[N][M];
    int count = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && map[i][j] > 0) {
          bfs(i, j);
          count++;
        }
      }
    }

    return count;
  }

  static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { x, y });
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dx[d];
        int ny = now[1] + dy[d];
        if (inBounds(nx, ny) && !visited[nx][ny] && map[nx][ny] > 0) {
          visited[nx][ny] = true;
          queue.add(new int[] { nx, ny });
        }
      }
    }
  }

  static boolean inBounds(int x, int y) {
    return 0 <= x && x < N && 0 <= y && y < M;
  }
}
