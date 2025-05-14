package dp_deepening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StoneGame3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean[] dp = new boolean[N + 5];  // N이 1일 수 있으니 크기 여유 있게

    // 초기 상태
    dp[1] = true;  // 1개면 상근이가 가져가서 이김
    dp[2] = false; // 어떤 걸 가져가도 창영이 이김
    dp[3] = true;
    dp[4] = true;

    for (int i = 5; i <= N; i++) {
      if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
        dp[i] = true;
      } else {
        dp[i] = false;
      }
    }

    System.out.println(dp[N] ? "SK" : "CY");
  }
}
