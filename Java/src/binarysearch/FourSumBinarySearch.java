package binarysearch;

import java.io.*;
import java.util.*;

public class FourSumBinarySearch {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] A = new int[n];
    int[] B = new int[n];
    int[] C = new int[n];
    int[] D = new int[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      A[i] = Integer.parseInt(st.nextToken());
      B[i] = Integer.parseInt(st.nextToken());
      C[i] = Integer.parseInt(st.nextToken());
      D[i] = Integer.parseInt(st.nextToken());
    }

    int[] sumAB = new int[n * n];
    int[] sumCD = new int[n * n];

    int idx = 0;
    for (int a : A) {
      for (int b : B) {
        sumAB[idx++] = a + b;
      }
    }

    idx = 0;
    for (int c : C) {
      for (int d : D) {
        sumCD[idx++] = c + d;
      }
    }

    Arrays.sort(sumCD);

    long result = 0;
    for (int x : sumAB) {
      int target = -x;
      int lower = findBound(sumCD, target, true);
      int upper = findBound(sumCD, target, false);
      result += (upper - lower);
    }

    System.out.println(result);
  }

  private static int findBound(int[] nums, int target, boolean isLower) {
    int start = 0;
    int end = nums.length;

    while (start < end) {
      int mid = (start + end) / 2;
      if (nums[mid] > target || (isLower && nums[mid] == target)) end = mid;
      else start = mid + 1;
    }
    return start;
  }
}
