package dp;

import java.util.Scanner;

public class N2Tiling2 {
  public static void main(String[] args) {
    int N = new Scanner(System.in).nextInt();

    if(N <= 2) {
      if(N == 1) System.out.println(1);
      if(N == 2) System.out.println(3);
      return;
    }

    int[] dp = new int[N+1];
    dp[1] = 1;
    dp[2] = 3;

    for (int i = 3; i <= N; i++) {
      dp[i] = dp[i - 1] + (2 * dp[i - 2]);
      dp[i] %= 10007;
    }

    System.out.println(dp[N]);
  }
}
