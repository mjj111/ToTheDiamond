package dp_deepening;

import java.util.Scanner;

public class Coin {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while(T-->0) {
      int N = sc.nextInt();

      int[] coins = new int[N];
      for(int i = 0; i < N; i++) coins[i] = sc.nextInt();
      int K = sc.nextInt();


      int[] dp = new int[K+1];
      dp[0] = 1;
      for(int coin : coins) {
        for(int i = coin; i <= K; i++) {
          dp[i] += dp[i - coin];
        }
      }

      System.out.println(dp[K]);
    }
  }
}
