package math;

import java.util.Scanner;

public class BinomialCoefficient {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[][] dp = new int[N + 1][M + 1];

    for (int n = 0; n <= N; n++) {
      dp[n][0] = 1;
      if (n <= M) dp[n][n] = 1;

      int k = 1;
      while (k < n && k <= M) {
        //NCK = (N-1 C k-1) + (N-1 C k)
        dp[n][k] = dp[n - 1][k - 1] + dp[n - 1][k];
        k++;
      }
    }


    System.out.println(dp[N][M]);
  }
}
