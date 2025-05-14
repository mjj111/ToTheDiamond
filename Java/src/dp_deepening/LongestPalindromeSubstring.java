package dp_deepening;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LongestPalindromeSubstring {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

    int[][] dp = new int[N][N];

    for (int i = 0; i < N; i++) {
      dp[i][i] = 1;
    }

    for (int i = 0; i < N - 1; i++) {
      if (nums[i] == nums[i+1]) {
        dp[i][i + 1] = 1;
      }
    }

    for (int len = 3; len <= N; len++) {
      for (int left = 0; left <= N - len; left++) {
        int right = left + len - 1;
        if (nums[left] == nums[right] && dp[left + 1][right - 1]==1) {
          dp[left][right] = 1;
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    while(T-->0) {
      st = new StringTokenizer(br.readLine());
      bw.write(dp[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]+ "\n");
    }
    bw.flush();
    bw.close();
  }
}
