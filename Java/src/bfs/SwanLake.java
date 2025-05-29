package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SwanLake {
  static int R, C;
  static char[][] map;
  static boolean[][] visited;
  static Queue<int[]> waterQ = new LinkedList<>();
  static Queue<int[]> swanQ = new LinkedList<>();
  static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static int[] swan1, swan2;

  static boolean isValid(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    R = sc.nextInt();
    C = sc.nextInt();
    sc.nextLine();

    map = new char[R][C];
    visited = new boolean[R][C];

    List<int[]> swans = new ArrayList<>();

    for (int r = 0; r < R; r++) {
      String line = sc.nextLine();
      for (int c = 0; c < C; c++) {
        map[r][c] = line.charAt(c);
        if (map[r][c] == 'L') {
          swans.add(new int[]{r, c});
        }
        if (map[r][c] != 'X') {
          waterQ.add(new int[]{r, c});
        }
      }
    }

    swan1 = swans.get(0);
    swan2 = swans.get(1);
    swanQ.add(swan1);
    visited[swan1[0]][swan1[1]] = true;

    int day = 0;

    while (true) {
      Queue<int[]> nextSwanQ = new LinkedList<>();

      while (!swanQ.isEmpty()) {
        int[] cur = swanQ.poll();
        int r = cur[0], c = cur[1];

        if (r == swan2[0] && c == swan2[1]) {
          System.out.println(day);
          return;
        }

        for (int[] d : directions) {
          int nr = r + d[0];
          int nc = c + d[1];

          if (!isValid(nr, nc) || visited[nr][nc]) continue;

          visited[nr][nc] = true;

          if (map[nr][nc] == 'X') {
            nextSwanQ.add(new int[]{nr, nc});
          } else {
            swanQ.add(new int[]{nr, nc});
          }
        }
      }

      // 얼음 녹이기
      int waterSize = waterQ.size();
      for (int i = 0; i < waterSize; i++) {
        int[] cur = waterQ.poll();
        int r = cur[0], c = cur[1];

        for (int[] d : directions) {
          int nr = r + d[0];
          int nc = c + d[1];

          if (!isValid(nr, nc)) continue;

          if (map[nr][nc] == 'X') {
            map[nr][nc] = '.';
            waterQ.add(new int[]{nr, nc});
          }
        }
      }

      swanQ = nextSwanQ;
      day++;
    }
  }
}
