package dp;

import java.util.Scanner;

public class CinemaSeat {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] vips = new int[M];
    for (int i = 0; i < M; i++) {
      vips[i] = sc.nextInt();
    }

    int[] dp = new int[N + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= N; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    int answer = 1;
    int prev = 0;

    for(int vip : vips) {
      int length = vip - prev - 1; // 구간 길이
      answer *= dp[length];
      prev = vip;
    }
    answer *= dp[N - prev];

    System.out.println(answer);
  }
}
