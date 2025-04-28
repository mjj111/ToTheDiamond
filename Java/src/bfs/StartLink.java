package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StartLink {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int F = sc.nextInt(); // 총 층 수
    int S = sc.nextInt(); // 시작 층
    int G = sc.nextInt(); // 목표 층
    int U = sc.nextInt(); // 위로 이동
    int D = sc.nextInt(); // 아래로 이동

    int[] visited = new int[F + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(S);
    visited[S] = 1;

    while (!q.isEmpty()) {
      int now = q.poll();

      if (now == G) {
        System.out.println(visited[now] - 1);
        return;
      }

      // 위로 이동
      int up = now + U;
      if (up <= F && visited[up] == 0) {
        visited[up] = visited[now] + 1;
        q.add(up);
      }

      // 아래로 이동
      int down = now - D;
      if (down >= 1 && visited[down] == 0) {
        visited[down] = visited[now] + 1;
        q.add(down);
      }
    }

    System.out.println("use the stairs");
  }
}
