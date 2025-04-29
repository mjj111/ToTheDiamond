package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TermProject {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] pick = new int[n + 1];
      int[] indegree = new int[n + 1];
      boolean[] visited = new boolean[n + 1];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        pick[i] = Integer.parseInt(st.nextToken());
        indegree[pick[i]]++;
      }

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 1; i <= n; i++) {
        if (indegree[i] == 0) {
          queue.add(i);
          visited[i] = true;
        }
      }

      while (!queue.isEmpty()) {
        int cur = queue.poll();
        int next = pick[cur];

        if (visited[next]) continue;

        indegree[next]--;
        if (indegree[next] == 0) {
          visited[next] = true;
          queue.add(next);
        }
      }

      int notInTeam = 0;
      for (int i = 1; i <= n; i++) {
        if (visited[i]) notInTeam++;
      }

      System.out.println(notInTeam);
    }
  }
}
