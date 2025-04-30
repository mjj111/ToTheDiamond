package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AscendingNumber {
  private static final int MOD =10007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] dp = new int[N + 1][10];
    for (int j = 0; j < 10; j++) {
      dp[1][j] = 1;
    }
    // dp[length][number]
    // length 길이이고 끝이 number인 경우의 수
    for (int i = 2; i <= N; i++) {
      for (int j = 0; j < 10; j++) {

        for (int k = 0; k <= j; k++) {
          dp[i][j] += dp[i - 1][k];
          dp[i][j] %= MOD;
        }
      }
    }

    int result = 0;
    for (int j = 0; j < 10; j++) {
      result = (result + dp[N][j]) % MOD;
    }

    System.out.println(result);
  }
}
