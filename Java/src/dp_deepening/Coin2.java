package dp_deepening;

import java.util.Arrays;
import java.util.Scanner;

public class Coin2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] coins = new int[n];

    for (int i = 0; i < n; i++) {
      coins[i] = scanner.nextInt();
    }

    int[] dp = new int[k + 1];
    Arrays.fill(dp, k + 1);
    dp[0] = 0;

    for (int coin : coins) {
      for (int j = coin; j <= k; j++) {
        dp[j] = Math.min(dp[j], dp[j - coin] + 1);
      }
    }

    System.out.println(dp[k] > k ? -1 : dp[k]);
  }
}
