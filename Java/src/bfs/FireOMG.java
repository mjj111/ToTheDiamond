package bfs;

import java.util.*;

public class FireOMG {
  static int R, C;
  static char[][] map;
  static int[][] fireTime;
  static int[][] jihunTime;
  static boolean[][] visited;
  static Queue<int[]> fireQueue = new LinkedList<>();
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    R = sc.nextInt();
    C = sc.nextInt();
    sc.nextLine();

    map = new char[R][C];
    fireTime = new int[R][C];
    jihunTime = new int[R][C];
    visited = new boolean[R][C];

    Queue<int[]> jihunQueue = new LinkedList<>();

    for (int i = 0; i < R; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = line.charAt(j);
        fireTime[i][j] = -1;
        jihunTime[i][j] = -1;

        if (map[i][j] == 'F') {
          fireQueue.offer(new int[]{i, j});
          fireTime[i][j] = 0;
        } else if (map[i][j] == 'J') {
          jihunQueue.offer(new int[]{i, j});
          jihunTime[i][j] = 0;
        }
      }
    }

    // 🔥 Step 1: 불의 확산 먼저 처리
    while (!fireQueue.isEmpty()) {
      int[] cur = fireQueue.poll();
      int x = cur[0], y = cur[1];

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
        if (map[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;

        fireTime[nx][ny] = fireTime[x][y] + 1;
        fireQueue.offer(new int[]{nx, ny});
      }
    }

    // 🚶 Step 2: 지훈이 이동
    while (!jihunQueue.isEmpty()) {
      int[] cur = jihunQueue.poll();
      int x = cur[0], y = cur[1];

      // 탈출 조건: 격자 밖으로 나가면 성공
      if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
        System.out.println(jihunTime[x][y] + 1);
        return;
      }

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
        if (map[nx][ny] == '#' || jihunTime[nx][ny] != -1) continue;

        // 불이 퍼지기 전이어야 이동 가능
        if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= jihunTime[x][y] + 1) continue;

        jihunTime[nx][ny] = jihunTime[x][y] + 1;
        jihunQueue.offer(new int[]{nx, ny});
      }
    }

    // 탈출 실패
    System.out.println("IMPOSSIBLE");
  }
}
