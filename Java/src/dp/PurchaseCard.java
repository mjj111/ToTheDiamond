package dp;

import java.util.Scanner;

public class PurchaseCard {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] price = new int[N+1];
    for (int i = 1; i <= N; i++) {
      price[i] = sc.nextInt();
    }

    // dp[i] = 카드 i장 살 때 최대 금액
    int[] dp = new int[N + 1];
    for (int total = 1; total <= N; total++) {
      for (int cardCount = 1; cardCount <= total; cardCount++) {
        dp[total] = Math.max(dp[total], dp[total - cardCount] + price[cardCount]);
      }
    }

    System.out.println(dp[N]);
  }
}
