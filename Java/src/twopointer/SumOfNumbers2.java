package twopointer;

import java.util.Scanner;

public class SumOfNumbers2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) nums[i] = sc.nextInt();


    int start = 0;
    int sum = 0;
    int count = 0;

    for (int end = 0; end < N; end++) {
      sum += nums[end];

      while (sum > M) sum -= nums[start++];
      if (sum == M) count++;
    }

    System.out.println(count);
  }
}
