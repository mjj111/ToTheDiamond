package dp_deepening;

import java.util.Scanner;

class LargestSquare {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    sc.nextLine();

    int[][] arr = new int[n + 1][m + 1];
    int[][] dp = new int[n + 1][m + 1];

    int maxLen = 0;

    for (int i = 1; i <= n; i++) {
      String line = sc.nextLine();
      for (int j = 1; j <= m; j++) {
        arr[i][j] = line.charAt(j - 1) - '0';

        if (arr[i][j] == 1) {
          dp[i][j] = Math.min(
              Math.min(dp[i - 1][j], dp[i][j - 1]),
              dp[i - 1][j - 1]
          ) + 1;
          maxLen = Math.max(maxLen, dp[i][j]);
        }
      }
    }

    System.out.println((int)Math.pow(maxLen,2));
  }
}
