package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Quit2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] works = new int[N + 1][2];

    for (int i = 1; i <= N; i++) {
      works[i][0] = sc.nextInt();
      works[i][1] = sc.nextInt();
    }

    int[] dp = new int[N + 2];

    for (int now = 1; now <= N; now++) {
      // 오늘까지의 최대 보수를 다음 날에도 이어받음
      dp[now] = Math.max(dp[now], dp[now - 1]);

      int require = works[now][0];
      int reward = works[now][1];

      int nextDay = now + require;
      if(nextDay > N+1) continue;
      dp[nextDay] = Math.max(dp[nextDay], dp[now] + reward);
    }

    System.out.println(Arrays.stream(dp).max().getAsInt());
  }
}
