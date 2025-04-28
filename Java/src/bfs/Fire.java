package bfs;

import java.util.*;
import java.io.*;

public class Fire {
  static int w, h;
  static char[][] map;
  static int[][] fireTime;
  static int[][] visited;
  static Queue<int[]> fireQ;
  static Queue<int[]> sangQ;

  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      map = new char[h][w];
      fireTime = new int[h][w];
      visited = new int[h][w];
      fireQ = new LinkedList<>();
      sangQ = new LinkedList<>();

      for (int i = 0; i < h; i++) {
        Arrays.fill(fireTime[i], -1);
        Arrays.fill(visited[i], -1);
      }

      for (int i = 0; i < h; i++) {
        String line = br.readLine();
        for (int j = 0; j < w; j++) {
          map[i][j] = line.charAt(j);
          if (map[i][j] == '*') {
            fireQ.offer(new int[]{i, j});
            fireTime[i][j] = 0;
          }
          if (map[i][j] == '@') {
            sangQ.offer(new int[]{i, j});
            visited[i][j] = 0;
          }
        }
      }

      spreadFire();
      moveSang();
    }
  }

  static void spreadFire() {
    while (!fireQ.isEmpty()) {
      int[] cur = fireQ.poll();
      int y = cur[0];
      int x = cur[1];

      for (int d = 0; d < 4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];

        if (!inRange(ny, nx)) continue;
        if (!isEmptyAndUnvisitedForFire(ny, nx)) continue;

        fireTime[ny][nx] = fireTime[y][x] + 1;
        fireQ.offer(new int[]{ny, nx});
      }
    }
  }

  static void moveSang() {
    while (!sangQ.isEmpty()) {
      int[] cur = sangQ.poll();
      int y = cur[0];
      int x = cur[1];

      if (y == 0 || y == h-1 || x == 0 || x == w-1) {
        System.out.println(visited[y][x] + 1);
        return;
      }

      for (int d = 0; d < 4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];

        if (!inRange(ny, nx)) continue;
        if (!isEmptyAndUnvisitedForSang(ny, nx)) continue;
        if (!canSangMoveBeforeFire(ny, nx, visited[y][x] + 1)) continue;

        visited[ny][nx] = visited[y][x] + 1;
        sangQ.offer(new int[]{ny, nx});
      }
    }
    System.out.println("IMPOSSIBLE");
  }

  static boolean inRange(int y, int x) {
    return 0 <= y && y < h && 0 <= x && x < w;
  }

  static boolean isEmptyAndUnvisitedForSang(int y, int x) {
    return map[y][x] == '.' && visited[y][x] == -1;
  }

  static boolean isEmptyAndUnvisitedForFire(int y, int x) {
    return map[y][x] == '.' && fireTime[y][x] == -1;
  }

  static boolean canSangMoveBeforeFire(int y, int x, int nextTime) {
    return fireTime[y][x] == -1 || fireTime[y][x] > nextTime;
  }
}
