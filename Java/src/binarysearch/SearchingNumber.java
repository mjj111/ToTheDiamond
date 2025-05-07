package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SearchingNumber {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(nums);

    int K = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    while(K-- > 0) {
      int require = Integer.parseInt(st.nextToken());
      int answer = findBinary(require, nums);
      System.out.println(answer);
    }
  }

  public static int findBinary(int require, int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    while(start <= end) {
      int mid = start + (end - start) / 2;
      if(nums[mid] == require) return 1;

      if(nums[mid] > require) end = mid - 1;
      else start = mid + 1;
    }
    return 0;
  }

}
