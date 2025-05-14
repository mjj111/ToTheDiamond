package dp_deepening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncodeNumber {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String code = br.readLine();
    int MOD = 1000000;
    int N = code.length();

    if (code.charAt(0) == '0') {
      System.out.println(0);
      return;
    }

    int[] dp = new int[N + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= N; i++) {
      char one = code.charAt(i - 1);
      char two1 = code.charAt(i - 2);
      int twoDigit = Integer.parseInt(code.substring(i - 2, i));

      // 한 자리 해석 가능(1-9) 10은 안된다. 0은 해석 불가.
      if (one >= '1' && one <= '9') {
        dp[i] += dp[i - 1];
        dp[i] %= MOD;
      }

      // 두 자리 해석 가능 (10~26) two가 0이면 02로 해석불가
      if (two1 != '0' && twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
        dp[i] %= MOD;
      }
    }

    System.out.println(dp[N]);
  }
}
