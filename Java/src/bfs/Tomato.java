package bfs;

import java.io.*;
import java.util.*;

public class Tomato {
  static int M, N, H;
  static int[][][] box;
  static Queue<TomatoNode> queue = new LinkedList<>();

  // 6방향 이동: 상하좌우 + 위아래
  static int[] dx = {1, -1, 0, 0, 0, 0};
  static int[] dy = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};

  static class TomatoNode {
    int x, y, z, day;
    public TomatoNode(int x, int y, int z, int day) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.day = day;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    box = new int[H][N][M];

    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
          box[h][n][m] = Integer.parseInt(st.nextToken());
          if (box[h][n][m] == 1) {
            queue.offer(new TomatoNode(m, n, h, 0));
          }
        }
      }
    }

    bfs();
  }

  static void bfs() {
    int day = 0;

    while (!queue.isEmpty()) {
      TomatoNode t = queue.poll();
      day = t.day;

      for (int i = 0; i < 6; i++) {
        int nx = t.x + dx[i];
        int ny = t.y + dy[i];
        int nz = t.z + dz[i];

        if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) continue;
        if (box[nz][ny][nx] != 0) continue;

        box[nz][ny][nx] = 1;
        queue.offer(new TomatoNode(nx, ny, nz, day + 1));
      }
    }

    if (checkAllRipen()) {
      System.out.println(day);
    } else {
      System.out.println(-1);
    }
  }

  static boolean checkAllRipen() {
    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        for (int m = 0; m < M; m++) {
          if (box[h][n][m] == 0) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
