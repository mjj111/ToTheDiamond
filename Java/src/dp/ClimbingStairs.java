package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {

  private static int NOT = 0;
  private static int STEPED = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] nums = new int[n+1];
    for (int i = 1; i <= n; i++) nums[i] = Integer.parseInt(br.readLine());

    if(n <= 2) {
      if(n == 1) System.out.println(nums[1]);
      if(n == 2) System.out.println(nums[2] + nums[1]);
      return;
    }

    int[][] dp = new int[2][n+1];
    dp[NOT][1] = dp[STEPED][1] =  nums[1];
    dp[NOT][2] = nums[2];
    dp[STEPED][2] = nums[2] + nums[1];

    for(int x = 3; x<= n; x++) {
      //이전 안밟고, x까지 오기
      // 밟고* 안밟고 전전꺼 + 현재 중에 최대
      dp[NOT][x]  = Math.max(dp[STEPED][x-2], dp[NOT][x-2]) + nums[x];

      //이전 밟고 x까지 오기
      //안밟은 전꺼 + 현재
      dp[STEPED][x] = dp[NOT][x-1] + nums[x];
    }

    System.out.println(Math.max(dp[NOT][n], dp[STEPED][n]));
  }
}
