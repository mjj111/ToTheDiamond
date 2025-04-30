package dp;

import java.util.Scanner;

public class N2Tiling {
  public static void main(String[] args) {
    int N = new Scanner(System.in).nextInt();

    if(N <= 2) {
      System.out.println(N);
      return;
    }

    int[] dp = new int[N + 1];
    dp[1] = 1;
    dp[2] = 2;

    for(int i = 3; i <= N; i++) {
      dp[i] = dp[i -1] + dp[i - 2];
      dp[i] %= 10007;
    }
    System.out.println(dp[N]);
  }
}
