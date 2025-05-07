package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class RouterInstallation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int C = sc.nextInt();

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) nums[i] = sc.nextInt();

    Arrays.sort(nums);

    int start = 1;
    int end = nums[N - 1] - nums[0];
    int answer = 0;

    while (start <= end) {
      int mid = (start + end) / 2;
      int count = calculate(mid, nums);

      if (count >= C) {
        answer = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    System.out.println(answer);
  }

  private static int calculate(int distance, int[] arr) {
    int count = 1;           // 첫 집엔 무조건 설치
    int lastInstalled = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - lastInstalled >= distance) {
        count++;
        lastInstalled = arr[i];
      }
    }

    return count;
  }
}
