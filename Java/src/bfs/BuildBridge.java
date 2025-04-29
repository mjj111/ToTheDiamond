package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildBridge {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static class Point {
    int x, y, dist, islandId;

    Point(int x, int y, int dist, int islandId) {
      this.x = x;
      this.y = y;
      this.dist = dist;
      this.islandId = islandId;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    map = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        map[i][j] = sc.nextInt();

    int islandId = 2; // 섬 ID를 2부터 시작해서 각각 다른 번호로 표시
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (map[i][j] == 1 && !visited[i][j])
          markIsland(i, j, islandId++);

    System.out.println(findShortestBridge());
  }

  static void markIsland(int x, int y, int id) {
    Queue<Point> q = new LinkedList<>();
    q.add(new Point(x, y, 0, id));
    visited[x][y] = true;
    map[x][y] = id;

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int d = 0; d < 4; d++) {
        int nx = p.x + dx[d];
        int ny = p.y + dy[d];

        if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
          visited[nx][ny] = true;
          map[nx][ny] = id;
          q.add(new Point(nx, ny, 0, id));
        }
      }
    }
  }

  static int findShortestBridge() {
    Queue<Point> q = new LinkedList<>();
    int[][] dist = new int[N][N];
    int[][] islandAt = new int[N][N];

    for (int i = 0; i < N; i++)
      Arrays.fill(dist[i], -1);

    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (map[i][j] > 0) {
          q.add(new Point(i, j, 0, map[i][j]));
          dist[i][j] = 0;
          islandAt[i][j] = map[i][j];
        }

    int minBridge = Integer.MAX_VALUE;

    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = p.x + dx[d];
        int ny = p.y + dy[d];

        if (!isIn(nx, ny)) continue;

        // 바다이거나 처음 방문
        if (map[nx][ny] == 0 && dist[nx][ny] == -1) {
          dist[nx][ny] = p.dist + 1;
          islandAt[nx][ny] = p.islandId;
          q.add(new Point(nx, ny, p.dist + 1, p.islandId));
        }

        // 다른 섬에서 온 흔적 발견
        else if (map[nx][ny] > 0 && map[nx][ny] != p.islandId) {
          minBridge = Math.min(minBridge, p.dist);
        }

        // 바다지만 이미 다른 섬에서 먼저 온 경우
        else if (dist[nx][ny] != -1 && islandAt[nx][ny] != p.islandId) {
          minBridge = Math.min(minBridge, dist[nx][ny] + p.dist);
        }
      }
    }

    return minBridge;
  }

  static boolean isIn(int x, int y) {
    return x >= 0 && y >= 0 && x < N && y < N;
  }
}
