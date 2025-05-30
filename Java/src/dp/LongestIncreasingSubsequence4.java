package dp;

import java.util.Scanner;
import java.util.Stack;

public class LongestIncreasingSubsequence4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      dp[i] = 1; // 초기값 설정
    }

    int lis = 1;

    // DP로 LIS 길이 구하기
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      lis = Math.max(lis, dp[i]);
    }

    // LIS 역추적
    Stack<Integer> stack = new Stack<>();
    int currentLIS = lis;
    for (int i = n - 1; i >= 0; i--) {
      if (dp[i] == currentLIS) {
        stack.push(arr[i]);
        currentLIS--;
      }
    }

    System.out.println(stack.size());
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }
}