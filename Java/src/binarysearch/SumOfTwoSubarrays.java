package binarysearch;

import java.io.*;
import java.util.*;

public class SumOfTwoSubarrays {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long T = Long.parseLong(br.readLine());

    int N = Integer.parseInt(br.readLine());
    long[] arrA = Arrays.stream(br.readLine().split(" "))
        .mapToLong(Long::parseLong)
        .toArray();

    int M = Integer.parseInt(br.readLine());
    long[] arrB = Arrays.stream(br.readLine().split(" "))
        .mapToLong(Long::parseLong)
        .toArray();

    long[] sumA = getAllSubarraySums(arrA);
    long[] sumB = getAllSubarraySums(arrB);

    Arrays.sort(sumB);

    long count = 0;
    for (long a : sumA) {
      long target = T - a;
      int lower = findBound(sumB, target, true);
      int upper = findBound(sumB, target, false);
      count += (upper - lower);
    }

    System.out.println(count);
  }

  private static long[] getAllSubarraySums(long[] arr) {
    List<Long> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      long sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        list.add(sum);
      }
    }
    return list.stream().mapToLong(Long::longValue).toArray();
  }

  private static int findBound(long[] nums, long target, boolean isLower) {
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

