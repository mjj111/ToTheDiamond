package binarysearch;

import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] nums = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    List<Integer> lis = new ArrayList<>();

    for (int num : nums) {
      int idx = lowerBound(lis, num);

      if (idx == lis.size()) lis.add(num);
      else lis.set(idx, num);
    }

    System.out.println(lis.size());
  }

  private static int lowerBound(List<Integer> list, int target) {
    int start = 0;
    int end = list.size();

    while (start < end) {
      int mid = (start + end) / 2;

      if (list.get(mid) >= target) end = mid;
      else start = mid + 1;
    }
    return start;
  }
}
