package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {
  private static int N;
  private static int K;
  private static int[] check = new int[100001];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    K = sc.nextInt();

    if (N == K) {
      System.out.println(0);
    } else {
      bfs(N);
    }
  }

  private static void bfs(int num) {
    Queue<Integer> q = new LinkedList<>();
    q.add(num);
    check[num] = 1;

    while (!q.isEmpty()) {
      int temp = q.poll();

      for (int i = 0; i < 3; i++) {
        int next = 0;

        if(i == 0) next = temp + 1;
        if(i == 1) next = temp - 1;
        if(i == 2) next = temp * 2;

        if(next == K) {
          System.out.println(check[temp]);
          return;
        }

        if (next >= 0 && next < check.length && check[next] == 0) {
          q.add(next);
          check[next] = check[temp] + 1;
        }
      }
    }
  }
}