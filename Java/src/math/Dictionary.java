package math;

import java.util.*;

public class Dictionary {
  static int a, z, k;
  static int[][] dp = new int[202][202];
  static StringBuilder ans = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    z = sc.nextInt();
    k = sc.nextInt();

    for (int i = 1; i <= 200; i++) {
      dp[i][0] = dp[i][i] = 1;

      for (int j = 1; j < i; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        if (dp[i][j] > 1_000_000_000) dp[i][j] = 1_000_000_001;
      }
    }

    while (a > 0 && z > 0) {
      // 현재 자리에 'a'를 선택하는 경우의 수
      int outcomes = dp[a + z - 1][a-1];
      if(k <= outcomes) {
        ans.append('a');
        a--;
      } else {
        // 'z'를 선택
        k -= outcomes;
        ans.append('z');
        z--;
      }
    }

    while (a-- > 0) ans.append('a');
    while (z-- > 0) ans.append('z');

    if (k > 1) System.out.println(-1);
    else System.out.println(ans.toString());
  }
}
