package dp_deepening;

import java.util.*;

public class FinalRank {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int time = 1; time <= T; time++) {
      int N = sc.nextInt();

      int[] inDegree = new int[N + 1];
      int[] array = new int[N + 1];

      for (int i = 1; i <= N; i++) {
        array[i] = sc.nextInt();
      }

      List<Integer>[] graph = new ArrayList[N + 1];
      for (int i = 1; i <= N; i++) {
        graph[i] = new ArrayList<>();
      }

      // 작년 순위를 바탕으로 초기 그래프 구성
      for (int i = 1; i <= N; i++) {
        int from = array[i];
        for (int j = i + 1; j <= N; j++) {
          int to = array[j];
          graph[from].add(to);
          inDegree[to]++;
        }
      }

      int M = sc.nextInt();
      for (int i = 0; i < M; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (graph[a].contains(b)) {
          graph[a].remove((Integer) b);
          graph[b].add(a);
          inDegree[b]--;
          inDegree[a]++;
        } else {
          graph[b].remove((Integer) a);
          graph[a].add(b);
          inDegree[a]--;
          inDegree[b]++;
        }
      }

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 1; i <= N; i++) {
        if (inDegree[i] == 0) queue.add(i);
      }

      StringBuilder result = new StringBuilder();
      boolean certain = true;
      int processed = 0;

      while (!queue.isEmpty()) {
        if (queue.size() > 1) {
          certain = false;
          break;
        }

        int current = queue.poll();
        result.append(current).append(" ");
        processed++;

        for (int next : graph[current]) {
          inDegree[next]--;
          if (inDegree[next] == 0) queue.add(next);
        }
      }

      if (processed != N) {
        System.out.println("IMPOSSIBLE");
      } else if (!certain) {
        System.out.println("?");
      } else {
        System.out.println(result.toString().trim());
      }
    }
  }
}
