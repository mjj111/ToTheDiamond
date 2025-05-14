package dp_deepening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonBag {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");


    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] dp = new int[N + 1][K + 1];
    int[][] bags = new int[N+1][2];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      bags[i][0] = Integer.parseInt(st.nextToken());
      bags[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= K; j++) {
        int weight = bags[i][0];
        int value = bags[i][1];
        // i번째 무게를 더 담을 수 없는 경우
        if(weight > j) dp[i][j] = dp[i - 1][j];

        // i번째 무게를 더 담을 수 있는 경우
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
      }
    }
    System.out.println(dp[N][K]);
  }
}