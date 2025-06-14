package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SynthesizingSolutions {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] nums = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(nums);

    int left = 0;
    int right = N - 1;

    long minDiff = Long.MAX_VALUE;
    long resultLeft = 0;
    long resultRight = 0;

    while (left < right) {
      long sum = nums[left] + nums[right];
      long absSum = Math.abs(sum);

      if (absSum < minDiff) {
        minDiff = absSum;
        resultLeft = nums[left];
        resultRight = nums[right];
      }

      if (sum < 0) left++;
      else right--;
    }

    System.out.println(resultLeft  + resultRight);
  }
}
