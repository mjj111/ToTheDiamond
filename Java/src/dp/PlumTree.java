package dp;

import java.util.Scanner;

public class PlumTree {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();  // 총 시간
    int W = sc.nextInt();  // 최대 이동 횟수

    int[] trees = new int[T];
    for (int i = 0; i < T; i++) {
      trees[i] = sc.nextInt() - 1;  // 0번 나무(왼쪽), 1번 나무(오른쪽)
    }

    int[][][] dp = new int[T][W + 1][2];  // dp[t][w][p] = t초에 w번 이동했고 위치가 p일 때 최대 자두 수

    // 초기 상태 설정
    if (trees[0] == 0) {
      dp[0][0][0] = 1;
    } else {
      dp[0][1][1] = 1;
    }

    for (int t = 1; t < T; t++) {
      for (int w = 0; w <= W; w++) {
        // 같은 위치 유지
        dp[t][w][0] = Math.max(dp[t][w][0], dp[t - 1][w][0]);
        dp[t][w][1] = Math.max(dp[t][w][1], dp[t - 1][w][1]);

        // 위치 변경
        if (w > 0) {
          dp[t][w][0] = Math.max(dp[t][w][0], dp[t - 1][w - 1][1]);
          dp[t][w][1] = Math.max(dp[t][w][1], dp[t - 1][w - 1][0]);
        }

        // 현재 위치에 자두가 떨어지면 증가
        if (trees[t] == 0) {
          dp[t][w][0]++;
        } else {
          dp[t][w][1]++;
        }
      }
    }

    int max = 0;
    for (int w = 0; w <= W; w++) {
      max = Math.max(max, Math.max(dp[T - 1][w][0], dp[T - 1][w][1]));
    }

    System.out.println(max);
  }
}
