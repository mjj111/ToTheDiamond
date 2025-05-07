package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

    twoPointerWithSet(nums);
  }

  private static void twoPointerWithSet(int[] nums) {
    long answer = 0;

    int start = 0;
    Set<Integer> currentSet = new HashSet<>();

    for (int end = 0; end < nums.length; end++) {
      while (currentSet.contains(nums[end])) {
        currentSet.remove(nums[start++]);
      }

      currentSet.add(nums[end]);
      answer += end - start + 1;
    }

    System.out.println(answer);
  }
}
