package math;

import java.util.*;

  public class PrimePath {
    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();

      sieve();

      while (T-- > 0) {
        int start = sc.nextInt();
        int end = sc.nextInt();

        int result = bfs(start, end);
        System.out.println(result == -1 ? "Impossible" : result);
      }
    }

    private static void sieve() {
      Arrays.fill(isPrime, true);
      isPrime[0] = isPrime[1] = false;
      for (int i = 2; i * i < 10000; i++) {
        if (isPrime[i]) {
          for (int j = i * i; j < 10000; j += i) {
            isPrime[j] = false;
          }
        }
      }
    }

    static int bfs(int start, int target) {
      boolean[] visited = new boolean[10000];
      Queue<int[]> queue = new LinkedList<>();
      queue.add(new int[]{start, 0});
      visited[start] = true;

      while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int num = current[0];
        int steps = current[1];

        if (num == target) return steps;

        for (int i = 0; i < 4; i++) {
          int pow10 = (int)Math.pow(10, i);
          int digit = (num / pow10) % 10;

          for (int d = 0; d <= 9; d++) {
            if (d == digit) continue;

            int next = num - digit * pow10 + d * pow10;
            if (next >= 1000 && isPrime[next] && !visited[next]) {
              visited[next] = true;
              queue.add(new int[]{next, steps + 1});
            }
          }
        }
      }

      return -1;
    }
  }
