package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MoveDestroyingWall {
  static class Node {
    int x, y, dist;
    boolean used;

    Node(int x, int y, int dist, boolean used) {
      this.x = x;
      this.y = y;
      this.dist = dist;
      this.used = used;
    }
  }

  static int n, m;
  static int[][] graph;
  static boolean[][][] visited;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    graph = new int[n][m];
    visited = new boolean[n][m][2];

    for (int i = 0; i < n; i++) {
      String line = sc.next();
      for (int j = 0; j < m; j++) {
        graph[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(bfs());
  }

  static int bfs() {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(0, 0, 1, false));
    visited[0][0][0] = true;

    while (!queue.isEmpty()) {
      Node cur = queue.poll();

      if (cur.x == n - 1 && cur.y == m - 1) {
        return cur.dist;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

        // 벽이 아닐 때
        if (graph[nx][ny] == 0) {
          if (!visited[nx][ny][cur.used ? 1 : 0]) {
            visited[nx][ny][cur.used ? 1 : 0] = true;
            queue.offer(new Node(nx, ny, cur.dist + 1, cur.used));
          }
        }

        // 벽일 때 & 아직 안 부쉈을 때
        else if (graph[nx][ny] == 1 && !cur.used && !visited[nx][ny][1]) {
          visited[nx][ny][1] = true;
          queue.offer(new Node(nx, ny, cur.dist + 1, true));
        }
      }
    }

    return -1;
  }
}
