package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SumIsZero {
  private static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    int[] nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(nums);

    long answer = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        int target = -(nums[i] + nums[j]);

        int lowerBoundIndex = findBound(nums, j, target, true);
        int upperBoundIndex = findBound(nums, j, target, false);

        answer += (upperBoundIndex - lowerBoundIndex);
      }
    }

    System.out.println(answer);
  }

  private static int findBound(int[] nums, int nowIdx, int target, boolean isLower) {
    int start = nowIdx+1;
    int end = nums.length;

    while (start < end) {
      int mid = (start + end) / 2;
      if (nums[mid] > target || (isLower && nums[mid] == target)) end = mid;
      else start = mid + 1;
    }
    return start;
  }
}
