package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSequence {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

    System.out.println(lengthOfLIS(nums));
  }

  public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int n = nums.length;
    int[] dp = new int[n];
    int maxLength = 1;

    for (int i = 0; i < n; i++) {
      dp[i] = 1; //본인의 길이 1
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }

    return maxLength;
  }
}