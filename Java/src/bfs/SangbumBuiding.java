package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SangbumBuiding {
  static class Point {
    int z, x, y, time;

    Point(int z, int x, int y, int time) {
      this.z = z;
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }

  static int[] dz = {1, -1, 0, 0, 0, 0}; // 위, 아래, 남, 북, 동, 서
  static int[] dx = {0, 0, 1, -1, 0, 0};
  static int[] dy = {0, 0, 0, 0, 1, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int L = sc.nextInt();
      int R = sc.nextInt();
      int C = sc.nextInt();
      if (L == 0 && R == 0 && C == 0) break;

      sc.nextLine(); // 개행 제거

      char[][][] building = new char[L][R][C];
      boolean[][][] visited = new boolean[L][R][C];

      int startZ = 0, startX = 0, startY = 0;

      for (int z = 0; z < L; z++) {
        for (int x = 0; x < R; x++) {
          String line = sc.nextLine();
          for (int y = 0; y < C; y++) {
            building[z][x][y] = line.charAt(y);
            if (building[z][x][y] == 'S') {
              startZ = z;
              startX = x;
              startY = y;
            }
          }
        }
        if (z < L - 1) sc.nextLine(); // 층 사이 빈 줄 제거
      }

      Queue<Point> queue = new LinkedList<>();
      queue.add(new Point(startZ, startX, startY, 0));
      visited[startZ][startX][startY] = true;

      boolean escaped = false;

      while (!queue.isEmpty()) {
        Point p = queue.poll();

        if (building[p.z][p.x][p.y] == 'E') {
          System.out.println("Escaped in " + p.time + " minute(s).");
          escaped = true;
          break;
        }

        for (int d = 0; d < 6; d++) {
          int nz = p.z + dz[d];
          int nx = p.x + dx[d];
          int ny = p.y + dy[d];

          if (nz >= 0 && nz < L && nx >= 0 && nx < R && ny >= 0 && ny < C) {
            if (!visited[nz][nx][ny] && building[nz][nx][ny] != '#') {
              visited[nz][nx][ny] = true;
              queue.add(new Point(nz, nx, ny, p.time + 1));
            }
          }
        }
      }

      if (!escaped) {
        System.out.println("Trapped!");
      }
    }
  }
}
