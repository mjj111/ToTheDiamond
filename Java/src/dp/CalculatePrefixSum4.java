package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CalculatePrefixSum4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] nums = new int[N+1];
    for(int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());

    int[] prefixSum = makePrefixSum(nums);

    while(M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      getPrefixSum(start, end, prefixSum);
    }
  }

  private static int[] makePrefixSum(int[] nums) {
    int[] prefixSum = new int[nums.length];
    for(int i = 1; i < nums.length; i++) {
      prefixSum[i] = prefixSum[i-1] + nums[i];
    }

    return prefixSum;
  }

  public static void getPrefixSum(int start, int end, int[] prefixSum) {
    System.out.println(prefixSum[end] - prefixSum[start-1]);
  }
}
