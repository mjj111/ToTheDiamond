package dp;

import java.util.Scanner;

public class PlusOneTwoThree3 {
  private static int MAX = 1000000;
  private static int MOD =  1000000009;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] dp = new int[MAX+1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    // 이전에 경우의 수를 더해야한다.
    for(int i = 4; i <= MAX; i++) {
      for(int n = 1; n<= 3; n++) {
        dp[i] += dp[i-n];
      }
      dp[i] %= MOD;
    }

    int testCase = sc.nextInt();
    while(testCase-- > 0) {
      int num = sc.nextInt();
      System.out.println(dp[num]);
    }
  }
}
