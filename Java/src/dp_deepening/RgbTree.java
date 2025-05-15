package dp_deepening;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class RgbTree {
  static final char[] COLOR = new char[]{'R', 'G', 'B'};
  static int n;
  static List<Integer>[] edges;
  static int[][] arr;
  static int[][] dp;
  static boolean[] v;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    n = Integer.parseInt(br.readLine());
    dp = new int[n+1][3];
    v = new boolean[n+1];

    edges = new List[n+1];
    for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      edges[a].add(b);
      edges[b].add(a);
    }

    arr = new int[n+1][3];
    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
      arr[i][2] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    edges[0].add(1);
    for (int i = 0; i < 3; i++) ans = max(ans, find(0, i));

    char[] selected = new char[n+1];
    Stack<int[]> trace = new Stack<>();
    for (int i = 0; i < 3; i++) {
      if (dp[0][i] == ans) {
        trace.push(new int[]{0, i});
        break;
      }
    }

    while (!trace.isEmpty()) {
      int[] cur = trace.pop();
      int idx = cur[0];
      int color = cur[1];
      selected[idx] = COLOR[color];

      for (int next : edges[idx]) {
        if (v[next]) continue;
        v[next] = true;

        int nextColor = -1;
        int nextMax = 0;
        for (int i = 0; i < 3; i++) {
          if (color == i) continue;

          if (nextMax < dp[next][i]) {
            nextMax = dp[next][i];
            nextColor = i;
          }
        }

        trace.push(new int[]{next, nextColor});
      }
    }

    System.out.println(ans);
    for (int i = 1; i <= n; i++) System.out.print(selected[i]);
  }

  static int find(final int idx, final int color) {
    if (dp[idx][color] != 0)
      return dp[idx][color];

    int sum = arr[idx][color];

    for (int next : edges[idx]) {
      if (v[next]) continue;
      v[next] = true;

      int max = 0;
      for (int i = 0; i < 3; i++) {
        if (color == i) continue;
        max = max(max, find(next, i));
      }
      sum += max;
      v[next] = false;
    }

    return dp[idx][color] = sum ;
  }
}
