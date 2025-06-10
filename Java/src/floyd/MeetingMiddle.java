package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class MeetingMiddle {
  static final int INF = 987987987;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] d = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      Arrays.fill(d[i], INF);
      d[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      d[x][y] = Math.min(d[x][y], cost);
    }

    int f = Integer.parseInt(br.readLine());
    int[] c = new int[f + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= f; i++) {
      c[i] = Integer.parseInt(st.nextToken());
    }

    // 플로이드-워셜
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (d[i][k] + d[k][j] < d[i][j]) {
            d[i][j] = d[i][k] + d[k][j];
          }
        }
      }
    }

    // 결과 저장용 리스트: (최대 거리, 노드 번호)
    ArrayList<int[]> v = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      int mx = 0;
      for (int ci = 1; ci <= f; ci++) {
        int dist = d[i][c[ci]] + d[c[ci]][i];
        if (dist > mx) mx = dist;
      }
      v.add(new int[]{mx, i});
    }

    // mx 기준으로 오름차순 정렬
    v.sort(Comparator.comparingInt(a -> a[0]));

    int mn = v.get(0)[0];
    StringBuilder sb = new StringBuilder();
    for (int[] cur : v) {
      if (cur[0] > mn) break;
      sb.append(cur[1]).append(' ');
    }

    System.out.println(sb.toString().trim());
  }
}
