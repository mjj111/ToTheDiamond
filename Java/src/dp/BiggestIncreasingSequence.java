package dp;

import java.util.Arrays;
import java.util.Scanner;

public class BiggestIncreasingSequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] nums = new int[n];
    int[] dp = new int[n];
    for (int i = 0; i < n; i++)  {
      nums[i] = sc.nextInt();
      dp[i] = nums[i];
    }

    // 본인 이전에 자기보다 작은 값을 만났다면
    // 해당 작은 값의 누적과 본인을 더해 갱신
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + nums[i]);
        }
      }
    }

    System.out.println(Arrays.stream(dp).max().getAsInt());
  }
}
