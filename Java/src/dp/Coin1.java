package dp;

import java.util.Scanner;

public class Coin1  {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] coins = new int[n];

    for (int i = 0; i < n; i++) {
      coins[i] = scanner.nextInt();
    }

    int[] dp = new int[k + 1];
    dp[0] = 1;

    //dp[i]
    //i원을 만드는 coin 조합 경우의 수
    for(int coin : coins) {
      for(int i = coin; i <= k; i++) {
        dp[i] += dp[i-coin];
      }
    }

    System.out.println(dp[k]);
  }
}

