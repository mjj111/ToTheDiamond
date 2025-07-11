package binarysearch;

import java.io.*;
import java.util.*;

public class NumberCard2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] cards = new int[N];
    for (int i = 0; i < N; i++) cards[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(cards);

    int M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(st.nextToken());
      int count = findBound(cards, target, false) - findBound(cards, target, true);
      sb.append(count).append(" ");
    }

    System.out.println(sb);
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
