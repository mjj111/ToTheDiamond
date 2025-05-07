package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SelectingNumber {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] nums = new int[N];
    for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

    Arrays.sort(nums);

    int start = 0;
    int answer = Integer.MAX_VALUE;

    for (int end = 1; end < N; end++) {
      while (nums[end] - nums[start] >= M) {
        answer = Math.min(answer, nums[end] - nums[start]);
        start++;
        if(start==end) break; // 두 포인터가 하나를 바라보면 안될 경우에 사용한다.
      }
    }

    System.out.println(answer);
  }
}