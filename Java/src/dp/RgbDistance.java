package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RgbDistance {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] rgb = new int[N+1][3];
    for(int i = 1 ; i<=N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j<3 ; j++) {
        rgb[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 인접한 집과는 색이 달라야한다.
    // 칠하는 비용 최소화

    int[][] dp = new int[N+1][3];
    for(int now = 1; now <= N; now++) {
      for(int color = 0; color < 3; color++) {
        int dif1 = color + 1 >= 3 ? 0 : color + 1;
        int dif2 = (color - 1) < 0 ? 2 : color -1;

        dp[now][color] = Math.min(dp[now-1][dif1], dp[now-1][dif2]) + rgb[now][color];
      }
    }

    System.out.println(Arrays.stream(dp[N]).min().getAsInt());
  }
}
