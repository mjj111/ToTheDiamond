package dp;

import java.util.Arrays;
import java.util.Scanner;

public class EasyStairCount {
  private static final int MOD = 1_000_000_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    //dp[length][number]
    // 길이가 Length고 마지막이 number인 계단수
    int[][] dp = new int[N + 1][10];
    for (int i = 1; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 0; j <= 9; j++) {

        if(j == 0) {
          dp[i][j] += dp[i - 1][j + 1];
        }
        else if(j == 9) {
          dp[i][j] += dp[i - 1][j - 1];
        }
        else {
          dp[i][j] += dp[i - 1][j - 1];
          dp[i][j] += dp[i - 1][j + 1];
        }

        dp[i][j] %= MOD;
      }
    }

    System.out.println(Arrays.stream(dp[N]).sum());
  }
}
